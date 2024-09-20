import java.util.Scanner;

public class StudentResults
 {

    public static String calculatingGrade(double percentage)
    {
        if (percentage >= 95) 
        {
            return "A+";
        } 
        else if (percentage >= 85)
        {
            return "A";
        }
        else if (percentage >= 75)
        {
            return "B";
        } 
        else if (percentage >= 65) 
        {
            return "C";
        }
        else if (percentage >= 55)
        {
            return "D";
        }
        else if (percentage >= 45) 
        {
            return "E";
        }
        else
        {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numsubjects = scanner.nextInt();
        int[] marks = new int[numsubjects];
        for (int i = 0; i < numsubjects; i++)
        {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

       
        double averagePercentage = (double) totalMarks / numsubjects;

        
        String grade = calculatingGrade(averagePercentage);

        
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
