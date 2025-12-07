import java.util.Scanner;
public class Gradecalculator{
      public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Ask the user for the number of subjects

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scan.nextInt();
        int totalMarks = 0;
        //Loop to get marks for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = scan.nextInt();
            totalMarks += marks;//Add marks to total
        }

        double average = (double) totalMarks / numberOfSubjects;//Calculate average
        char grade;
        String message;
        //Determine grade and compliment based on average

        if (average >= 90) {
            grade = 'A';
            message="Excellent work! You are performing at the top level.";
        } else if (average >= 80) {
            grade = 'B';
            message="Well done! Your consistency shows.";
        } else if (average >= 70) {
            grade = 'C';
            message="Good effort ! A bit more focus can push you even higher.";
        } else if (average >= 60) {
            grade = 'D';
            message="You made it through ! Keep practiscing and you will improve";
        } else {
            grade = 'F';
            message ="Don't worry, Every setback is a chance to rise .Keep trying!";
        }
        //Display results

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Message: "+message);

        scan.close();
    }
}