package Game;

public class GameEntry {

    protected String name;   // player's name
    protected int score;     // player's score

    // Constructor
    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // To print the entry
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}

