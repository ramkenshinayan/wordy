package src.objs;

import serverInt.WordyModule.InvalidWordException;
import serverInt.WordyModule.NoWinnerException;
import serverInt.WordyModule.NotEnoughPlayers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static src.WordyImpl.con;
public class GameRoom {

    private List<Player> players = new ArrayList<>(); //Player(username, roundWins)
    private List<Player> wordsByPlayers = new ArrayList<>(); //Player(username, word)
    private List<Player> roundWinners = new ArrayList<>(); //Player(username, longestWord)
    private char[] letters;
    private Player roundWinner;
    private Player gameWinner;
    private int time;
    public boolean gameStarted = false;
    public boolean roundEnded = false;
    public boolean gameEnded = false;
    private static final int roundTimeLimit = 10000;
    private Timer roundStartTimer = new Timer();
    private CountDownLatch startLatch = new CountDownLatch(1);
    private CountDownLatch enoughPlayersLatch = new CountDownLatch(1);

    //============GAME METHODS==================
    public void initGame(Player player) throws NotEnoughPlayers {
        if (gameStarted) {
            return;
        }
        players.add(player);
        try {
            if (players.size() == 1) {
                System.out.println(player.getUsername() + " created a room. Waiting for other players to join...");
                timer(11);
                boolean enoughJoined = enoughPlayersLatch.await(11, TimeUnit.SECONDS);
                if (!enoughJoined) {
                    System.out.println("Not enough players. Game cancelled.");
                    players.clear();
                    enoughPlayersLatch = new CountDownLatch(1); // Reset the latch for the next game initiation
                    startLatch = new CountDownLatch(1); // Reset the latch for the next game initiation
                    throw new NotEnoughPlayers("Not enough players. Game cancelled.");
                } else {
                    startLatch.await(time, TimeUnit.SECONDS); // Wait for 10 seconds before starting the game
                    startLatch.countDown(); // Signal that the initiating player can start the game
                }
            } else {
                System.out.println(player.getUsername() + " joined. Waiting for game start...");
                enoughPlayersLatch.countDown(); // Signal that a player has joined
                startLatch.await(time, TimeUnit.SECONDS); // Wait for 10 seconds before starting the game
            }

            if (players.size() > 1 && !gameStarted) {
                gameStarted = true; // Set the flag to indicate that the game has started
                startGame();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void timer(int secs) {
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                time = secs;
                while (time > 0) {
                    time--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        timer.start();
    }

    private void startGame() {
        generateLetters();
        System.out.println("Prepared Letters: " + Arrays.toString(letters));
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    endRound();
                } catch (NoWinnerException e) {
                    System.err.println(e.reason);
                } finally {
                    roundEnded = true;
                }
            }
        }, roundTimeLimit);
    }

    private void startNewRound() {
        try {
            roundStartTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        displayPlayerScores();
                        wordsByPlayers.clear();
                        roundWinners.clear();
                        startGame();
                    } finally {
                        roundEnded = false;
                    }
                }
            }, 5000);
            roundEnded = false; // Reset the flag to indicate that the round has not ended
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayPlayerScores() {
        System.out.println("Current Scores:");
        for (Player player : players) {
            System.out.println(player.getUsername() + ": " + player.getRoundWins());
        }
    }

    private void endRound() throws NoWinnerException {
        roundEnded = true;
        try {
            roundWinner = getRoundWinner();
            System.out.println("Round ended. Round winner: " + roundWinner.getUsername());

            for (Player player : players) {
                if (player.getUsername().equals(roundWinner.getUsername())) {
                    player.setRoundWins(player.getRoundWins() + 1);
                    if (player.getRoundWins() == 3) {
                        System.out.println("Game over. Winner: " + player.getUsername());
                        gameWinner = player;
                        gameEnded = true;
                    }
                    break;
                }
            }

            if (gameEnded) {
                updateTopPlayers();
                Timer delayTimer = new Timer();
                delayTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        resetWinners();
                    }
                }, 25000); // Delay for 5 seconds before resetting the winners
            }

            if (!gameEnded) {
                System.out.println("Starting a new round...");
                startNewRound();
            }

            wordsByPlayers.clear();

        } catch (NoWinnerException e) {
            System.err.println(e.reason);
            if (!gameEnded) {
                System.out.println("Starting a new round...");
                startNewRound();
            } else {
                throw e; // Rethrow the exception to handle it in the WordyClientMain class
            }
        }
    }

    public void resetWinners() {
        gameWinner = null;
        roundWinner = null;
        roundWinners.clear();
        wordsByPlayers.clear();
        players.clear();
    }
    public void updateTopPlayers() {
        try {
            for (Player player : players) {
                String username = player.getUsername();
                int roundsWon = player.getRoundWins();
                int gamesWon = player.getUsername().equals(gameWinner.getUsername()) ? 1 : 0;

                // Check if player exists in the database
                String selectQuery = "SELECT * FROM topplayers WHERE username = ?";
                try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
                    selectStatement.setString(1, username);
                    ResultSet resultSet = selectStatement.executeQuery();

                    if (resultSet.next()) {
                        // Player exists, update the values
                        int currentRoundsWon = resultSet.getInt("roundsWon");
                        int currentGamesWon = resultSet.getInt("gamesWon");
                        roundsWon += currentRoundsWon; // Only add the current roundsWon value to the existing value
                        gamesWon += currentGamesWon;

                        String updateQuery = "UPDATE topplayers SET roundsWon = ?, gamesWon = ? WHERE username = ?";
                        try (PreparedStatement updateStatement = con.prepareStatement(updateQuery)) {
                            updateStatement.setInt(1, roundsWon);
                            updateStatement.setInt(2, gamesWon);
                            updateStatement.setString(3, username);
                            updateStatement.executeUpdate();
                        }
                    } else {
                        // Player does not exist, insert a new row
                        String insertQuery = "INSERT INTO topplayers (username, roundsWon, gamesWon) VALUES (?, ?, ?)";
                        try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                            insertStatement.setString(1, username);
                            insertStatement.setInt(2, roundsWon);
                            insertStatement.setInt(3, gamesWon);
                            insertStatement.executeUpdate();
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void generateLetters() {
        char[] generatedLetters = new char[17];
        Random random = new Random();
        String vowels = "AEIOU";
        String consonants = "BCDFGHJKLMNPQRSTVWXYZ";

        int numVowels = ThreadLocalRandom.current().nextInt(5, 8);
        for (int i = 0; i < generatedLetters.length; i++) {
            if (i < numVowels) {
                generatedLetters[i] = vowels.charAt(random.nextInt(vowels.length()));
            } else {
                generatedLetters[i] = consonants.charAt(random.nextInt(consonants.length()));
            }
        }
        List<Character> list = new ArrayList<>();
        for (char c : generatedLetters) {
            list.add(c);
        }
        Collections.shuffle(list, random);
        for (int i = 0; i < list.size(); i++) {
            generatedLetters[i] = list.get(i);
        }
        letters = generatedLetters;
    }

    public boolean userExists(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    //============WORD INPUT METHODS============
    public void submitWord(String username, String word) throws InvalidWordException {
        if (word.length() >= 5) {
            if (!isWordTaken(username, word)) {
                if (isWordBasedOnGiven(word, letters)) {
                    if (isWordValid(word)) {
                        if (!roundEndFlag()) {
                            System.out.println(username + " valid word input: " + word);
                            wordsByPlayers.add(new Player(username, word));
                            toDatabase(username, word, word.length()); // Insert word into the leaderboard table
                        } else {
                            throw new InvalidWordException("Cannot Submit Words Anymore. Round has already ended");
                        }
                    } else {
                        throw new InvalidWordException("Invalid word - Word is not in the list");
                    }
                } else {
                    throw new InvalidWordException("Invalid word - Use the letters provided");
                }
            } else {
                throw new InvalidWordException("Invalid word - Word is taken");
            }
        } else {
            throw new InvalidWordException("Invalid word - Word should be at least 5 letters and above");
        }
    }

    private void toDatabase(String username, String word, int letterCount) {
        String query = "INSERT INTO toplongestword (username, word, letterCount) VALUES (?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, word);
            statement.setInt(3, letterCount);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isWordTaken(String username, String word) {
        for (Player playerWord : wordsByPlayers) {
            if (playerWord.getWord().equals(word) && playerWord.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWordValid(String word) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Server_Java/res/words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isWordBasedOnGiven(String word, char[] generatedLetters) {
        char[] wordLetters = word.toCharArray();
        List<Character> generatedLetterList = new ArrayList<>();
        for (char c : generatedLetters) {
            generatedLetterList.add(Character.toUpperCase(c));
        }
        for (char c : wordLetters) {
            Character uppercaseChar = Character.toUpperCase(c);
            if (!generatedLetterList.contains(uppercaseChar)) {
                return false;
            }
            generatedLetterList.remove(uppercaseChar);
        }
        return true;
    }

    //============GETTERS======================
    public char[] getLetters() {
        return letters;
    }

    public Player getGameWinner() {
        return gameWinner;
    }

    public Player getRoundWinner() throws NoWinnerException {
        int maxLength = 0;
        for (Player player : wordsByPlayers) {
            if (player.getWord().length() > maxLength) {
                maxLength = player.getWord().length();
                roundWinners.clear();
                roundWinners.add(player);
            } else if (player.getWord().length() == maxLength) {
                roundWinners.add(player);
            }
        }

        if (roundWinners.size() > 1) {
            if (roundWinners.get(0).getUsername().equals(roundWinners.get(1).getUsername())) {
                roundWinner = roundWinners.get(0);
            } else {
                throw new NoWinnerException("No Winner (Tie between players)");
            }
        } else if (roundWinners.size() == 1) {
            roundWinner = roundWinners.get(0);
        } else if (wordsByPlayers.isEmpty()) {
            throw new NoWinnerException("No winner (Players failed to send valid words).");
        }

        for (Player player : players) {
            if (player.getUsername().equals(roundWinner.getUsername())) {
                roundWinner.setRoundWins(player.getRoundWins());
                break;
            }
        }
        return roundWinner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getTime() {
        return time;
    }

    public boolean gameStartFlag() {
        return gameStarted;
    }

    public boolean gameEndFlag() {
        return gameEnded;
    }

    public boolean roundEndFlag() {
        return roundEnded;
    }

}
