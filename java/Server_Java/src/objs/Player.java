package src.objs;

public class Player {
    private String username;
    private int roundWins;
    private String word;

    public Player(String username) {
        this.username = username;
        roundWins = 0;
    }

    public Player(String username, String word) {
        this.username = username;
        this.word = word;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoundWins() {
        return roundWins;
    }

    public void setRoundWins(int roundWins) {
        this.roundWins = roundWins;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
