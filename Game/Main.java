package Game;

public class Main {
    public static void main(String[] args) {

        HighScores scores = new HighScores(10);   // leaderboard of size 10

        // Add some game entries
        scores.add(new GameEntry("Rob", 750));
        scores.add(new GameEntry("Anna", 660));
        scores.add(new GameEntry("Jack", 510));
        scores.add(new GameEntry("Mike", 1105));
        scores.add(new GameEntry("Paul", 720));
        scores.add(new GameEntry("Rose", 590));

        // Print the leaderboard
        System.out.println("HIGH SCORES:");
        System.out.println(scores);
    }
}

