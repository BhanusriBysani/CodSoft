import java.util.Scanner;

public class Quiz {
    
    static class Question {
        String question;
        String[] options;
        char correctAnswer;

        Question(String question, String[] options, char correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }


    static Question[] questions = {
        new Question("who is the primeminister of India?", new String[]{"A.Chandrababu", "B.Narendra modi", "C.Pawan Kalyan", "D.NaraLokesh"}, 'B'),
        new Question("what is largest desert in the world?", new String[]{"A.Sahara", "B.Gobi", "C. Arctic", "D.Kalahari"}, 'C'),
        new Question("W.ho is considered the father of computer", new String[]{"A.CharlesBabbage", "B.BillGates", "C. Steevejobs", "D.AlanMusk"}, 'A')
        
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int questionTimeLimit = 10; // Time limit per question in seconds

        // Iterate through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ":");
            displayQuestion(questions[i]);
            
            
            long startTime = System.currentTimeMillis();
            String answer = getAnswer(scanner, questionTimeLimit);
            long endTime = System.currentTimeMillis();

            if (endTime - startTime <= questionTimeLimit * 1000 && answer.length() == 1) {
                char userAnswer = answer.toUpperCase().charAt(0);
                if (userAnswer == questions[i].correctAnswer) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer was: " + questions[i].correctAnswer);
                }
            } else {
                System.out.println("Time's up! The correct answer was: " + questions[i].correctAnswer);
            }
            
            System.out.println(); 
        }

        
        System.out.println("Quiz finished!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
    }

    
    public static void displayQuestion(Question question) {
        System.out.println(question.question);
        for (String option : question.options) {
            System.out.println(option);
        }
    }

    
    public static String getAnswer(Scanner scanner, int timeLimit) {
        final String[] answer = {""};

        
        Runnable inputTask = () -> {
            System.out.print("Your answer: ");
            answer[0] = scanner.nextLine();
        };
        Thread inputThread = new Thread(inputTask);
        inputThread.start();

        try {
            inputThread.join(timeLimit * 1000); 
            if (inputThread.isAlive()) {
                inputThread.interrupt(); 
                System.out.println("\nNo answer given within time limit.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return answer[0];
    }
}
