package projects;

import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private String correctAnswer;

    Question(String questionText, String correctAnswer, List<String> options) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim());
    }

    public void display() {
        System.out.println(questionText);

        for (String option : options) {
            System.out.println(option);
        }
    }
}

class QuizeBank {

    private List<Question> questions;
    private Random rand;

    QuizeBank() {
        questions = new ArrayList<>();
        rand = new Random();
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public int size() {
        return questions.size();
    }

    public Question getRandomQuestion() {
        int index = rand.nextInt(questions.size());
        return questions.get(index);
    }

    public List<Question> getRandQuestions(int count) {
        List<Question> copy = new ArrayList<>(questions);
        Collections.shuffle(copy, rand);

        return copy.subList(0, count);
    }
}

class QuizeEngine {

    private QuizeBank bank;
    private Scanner sc;
    private int score;
    private int totalAsked;
    private long totalTime;
    private String grade;
    private int highScore = 0;

    QuizeEngine(QuizeBank bank, Scanner sc) {
        this.bank = bank;
        this.sc = sc;
        this.score = 0;
        this.totalAsked = 0;
    }

    public boolean askQuestion(Question q) {
        System.out.println("\n--- Question " + (totalAsked + 1) + "-----");
        q.display();
        System.out.print("Your answer: ");

        long start = System.currentTimeMillis();
        String answer = sc.nextLine();
        long timeTaken = (System.currentTimeMillis() - start) / 1000;
        totalTime += timeTaken;
        totalAsked++;

        if (q.isCorrect(answer)) {
            System.out.println("Correct! (Time: " + timeTaken + "s");
            score++;
            if (score > highScore) {
            highScore = score;
            System.out.println("🏆 New High Score: " + highScore + "!");
}
            return true;
        } else {
            System.out.println("Wrong! Correct answer was: " + q.getCorrectAnswer() + " (Time: " + timeTaken + "s");
            return false;
        }
    }

    public void startQuize(int count) {
        List<Question> selected = bank.getRandQuestions(count);
        for (Question q : selected) {
            askQuestion(q);
        }
    }

    public int getScore() {
        return score;
    }

    public int getTotalAsked() {
        return totalAsked;
    }

    public void printResult() {

        if (totalAsked == 0) {
            System.out.println("No question were asked.");
            return;
        }

        double accuracy = (score * 100.0) / totalAsked;

        if (accuracy >= 90) {
            grade = "A";
        } else if (accuracy >= 80) {
            grade = "B";
        } else if (accuracy >= 70) {
            grade = "C";
        } else if (accuracy >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("=====================");
        System.out.println("Score\t\t: " + score + " / " + totalAsked);
        System.out.println("Accuracy\t: " + String.format("%.2f", accuracy) + "%");
        System.out.println("Time\t\t: " + totalTime + "s");
        System.out.println("Grade\t\t: " + grade);
        System.out.println("=====================");
    }

    public void resetQuize() {
        score = 0;
        totalAsked = 0;
        totalTime = 0;
    }

    public int getHighScore() {
        return highScore;
    }
}

public class Quize_Game {
    public static void main(String[] args) {
        QuizeBank bank = new QuizeBank();
        bank.addQuestion(new Question("Which keyword is used to create a class in Java?", "B",
                List.of("A. create", "B. class", "C. new", "D. object")));

        bank.addQuestion(new Question(
                "Which method is the entry point of a Java program?", "C",
                List.of("A. start()", "B. run()", "C. main()", "D. init()")));

        bank.addQuestion(new Question("Which keyword is used to create an object in Java?", "A",
                List.of("A. new", "B. object", "C. class", "D. create")));

        bank.addQuestion(new Question("Which data type is used to store whole numbers?", "B",
                List.of("A. float", "B. int", "C. char", "D. boolean")));

        bank.addQuestion(new Question("Which symbol is used to end a statement in Java?", "D",
                List.of("A. :", "B. ,", "C. .", "D. ;")));

        bank.addQuestion(new Question("Which keyword is used for inheritance in Java?", "A",
                List.of("A. extends", "B. implements", "C. inherit", "D. super")));

        try (Scanner sc = new Scanner(System.in)) {
            QuizeEngine engine = new QuizeEngine(bank, sc);
            while (true) {
                System.out.println("\n======= Quiz Game =======");
                System.out.println("1. Start Quiz");
                System.out.println("2. View High Score");
                System.out.println("3. Exit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        while (true) {                    // 👈 ADD this
                            System.out.print("How many questions? (max " + bank.size() + "): ");
                            int count = sc.nextInt();
                            sc.nextLine();

                            if (count > bank.size()) {
                            System.out.println("Only " + bank.size() + " questions available!");
                            continue;
                            }

                            engine.startQuize(count);
                            engine.printResult();

                            System.out.print("\nPlay again? (yes/no): ");
                            String again = sc.nextLine();
                            if (again.equalsIgnoreCase("yes")) {
                            engine.resetQuize();
                            } else {
                            break; 
                            }
                        }                                 
                            break;
                    case 2:
                        
                        System.out.println("🏆 High Score: " + engine.getHighScore());
    
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
            
        }
}}
