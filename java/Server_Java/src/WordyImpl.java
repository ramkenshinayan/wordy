package src;

import serverInt.WordyModule.*;
import org.omg.CORBA.ORB;
import src.objs.GameRoom;
import src.objs.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordyImpl extends WordyPOA {

    private ORB orb;
    public static Connection con;
    public GameRoom gameRoom;
    public ArrayList<GameRoom> gameRooms = new ArrayList<>();

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public static void setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordy", "root", "");
            System.out.println("Database Connection Established! ");
        } catch (Exception e) {
            System.out.println("Database Connection Failed.");
        }
    }

    //============ACCOUNT METHODS==================
    @Override
    public void login(String username, String password) throws InvalidLoginException {
        String userExist = "SELECT userName FROM logincredentials WHERE userName = ?";
        String validateLoginCredentials = "SELECT userName, userPass, status FROM logincredentials WHERE BINARY userName = ? AND BINARY userPass = ?";
        String setAsLogged = "UPDATE logincredentials SET status = ? WHERE userName = ?";

        try {
            // Check if the user exists
            PreparedStatement existStatement = con.prepareStatement(userExist);
            existStatement.setString(1, username);
            ResultSet existResultSet = existStatement.executeQuery();

            if (!existResultSet.next()) {
                throw new InvalidLoginException("User Doesn't Exist.");
            }

            // Validate login credentials
            PreparedStatement validateStatement = con.prepareStatement(validateLoginCredentials);
            validateStatement.setString(1, username);
            validateStatement.setString(2, password);
            ResultSet rs = validateStatement.executeQuery();

            if (!rs.next()) {
                throw new InvalidLoginException("Invalid password. Please try again.");
            } else {
                String status = rs.getString(3);
                if (status.equalsIgnoreCase("Active")) {
                    throw new InvalidLoginException("This user is already logged in.");
                } else {
                    // Set the user as logged in
                    PreparedStatement setLoggedStatement = con.prepareStatement(setAsLogged);
                    setLoggedStatement.setString(1, "Active");
                    setLoggedStatement.setString(2, username);
                    System.out.println("User (" + username + ") logged in.");
                    setLoggedStatement.executeUpdate();
                }
            }

            rs.close();
            validateStatement.close();
        } catch (SQLException e) {
            System.out.println("Error: Cannot login!");
        }
    }

    @Override
    public void logout(String username) {
        String query = "UPDATE logincredentials SET status =? WHERE userName =?";
        try {
            PreparedStatement statement2 = con.prepareStatement(query);
            statement2.setString(1, "Inactive");
            statement2.setString(2, username);
            statement2.executeUpdate();
            System.out.println("User: (" + username + ") Logged out.");
        } catch (SQLException e) {
            System.out.println("\nError: Cannot Log out! ");
        }
    }

    //============GAME METHODS==================
    @Override
    public void initiateGame(String username) throws NotEnoughPlayers {
        Player player = new Player(username);
        gameRoom = findRoom();
        gameRoom.initGame(player);
    }

    public GameRoom findRoom() {
        for (GameRoom room : gameRooms) {
            if (!room.gameStarted) {
                return room;
            }
        }
        GameRoom newRoom = new GameRoom();
        gameRooms.add(newRoom);
        return newRoom;
    }

    @Override
    public char[] getLetters(String username) {
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                return game.getLetters();
            }
        }
        return null;
    }

    @Override
    public void submitWord(String username, String word) throws InvalidWordException {
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                game.submitWord(username, word);
            }
        }
    }

    @Override
    public RoundWinner_ getRoundWinner(String username) throws NoWinnerException {
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                Player roundWinner = game.getRoundWinner();
                return new RoundWinner_(roundWinner.getUsername(), roundWinner.getWord(), roundWinner.getRoundWins());
            }
        }
        return null;
    }

    @Override
    public String getGameWinner(String username) {
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                return game.getGameWinner().getUsername();
            }
        }
        return null;
    }

    @Override
    public void disposeGame(String username) {
        GameRoom gameToRemove = null;
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                gameToRemove = game;
                break;
            }
        }
        if (gameToRemove != null) {
            gameRooms.remove(gameToRemove);
        }
    }

    //============GETTERS==================

    @Override
    public Player_[] getAllPlayers(String username) {
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                List<Player> players = game.getPlayers();
                Player_[] playerArray = new Player_[players.size()];
                for (int i = 0; i < players.size(); i++) {
                    Player player = players.get(i);
                    playerArray[i] = new Player_(player.getUsername(), player.getRoundWins());
                }
                return playerArray;
            }
        }
        return new Player_[0];
    }

    @Override
    public int getTime(String username) {
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                return  game.getTime();
            }
        }
        return 0;
    }

    @Override
    public TopLongestWord getLongestWord(int index) {
        ArrayList<TopLongestWord> topLongestWordsList = new ArrayList<>();
        String query = "SELECT username, word, letterCount FROM toplongestword ORDER BY letterCount DESC LIMIT 5";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String word = rs.getString("word");
                Integer letterCount = rs.getInt("letterCount");
                TopLongestWord entry = new TopLongestWord(username, word, letterCount);
                topLongestWordsList.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topLongestWordsList.get(index);
    }

    @Override
    public int getLongestWordsSize() {
        int numberOfEntries = 0;
        String query = "SELECT COUNT(*) AS entryCount FROM toplongestword";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                numberOfEntries = rs.getInt("entryCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfEntries;
    }

    @Override
    public TopPlayer getTopPlayers(int index) {
        ArrayList<TopPlayer> topPlayersList = new ArrayList<>();
        String query = "SELECT username, roundsWon, gamesWon FROM topplayers ORDER BY gamesWon DESC, roundsWon DESC LIMIT 5;";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                Integer roundsWon = rs.getInt("roundsWon");
                Integer gamesWon = rs.getInt("gamesWon");
                TopPlayer entry = new TopPlayer(username, roundsWon, gamesWon);
                topPlayersList.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (index > topPlayersList.size() - 1 || topPlayersList.get(index) == null) {
            return null;
        } else {
            return topPlayersList.get(index);
        }
    }

    @Override
    public int getTopPlayersSize() {
        int numberOfEntries = 0;
        String query = "SELECT COUNT(*) AS entryCount FROM topplayers";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                numberOfEntries = rs.getInt("entryCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfEntries;
    }

    @Override
    public boolean gameStartFlag(String username) {
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                return game.gameStartFlag();
            }
        }
        return false;
    }

    @Override
    public boolean gameEndFlag(String username) {
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                return game.gameEndFlag();
            }
        }
        return false;
    }

    @Override
    public boolean roundEndFlag(String username) {
        for (GameRoom game : gameRooms) {
            if (game.userExists(username)) {
                return game.roundEndFlag();
            }
        }
        return false;
    }

}

