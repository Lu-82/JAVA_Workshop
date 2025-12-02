package Game;

public class HighScores {

    private int maxEntries;        // max number of entries allowed
    private int numEntries;        // how many entries are stored currently
    private GameEntry[] entries;   // array of GameEntry objects

    // Constructor
    public HighScores(int maxE) {
        maxEntries = maxE;
        entries = new GameEntry[maxE];
        numEntries = 0;
    }

    // Add a new entry in sorted position
    public void add(GameEntry e) {
        int newScore = e.getScore();

        // case 1: array full AND score is too low → reject
        if (numEntries == maxEntries && newScore <= entries[numEntries - 1].getScore()) {
            return;
        }

        // case 2: array not full → increase number of entries
        if (numEntries < maxEntries) {
            numEntries++;
        }

        // shift lower scores to make space
        int i = numEntries - 1;
        while (i > 0 && entries[i - 1].getScore() < newScore) {
            entries[i] = entries[i - 1];
            i--;
        }

        // insert the new score
        entries[i] = e;
    }

    // Show leaderboard
    public String toString() {
        String result = "";
        for (int i = 0; i < numEntries; i++) {
            result += entries[i] + "\n";
        }
        return result;
    }
}
