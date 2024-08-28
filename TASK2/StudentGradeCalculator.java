import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        float total_sum = 0;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Number of subjects:");
            int numOfSubjects = sc.nextInt();

            if (numOfSubjects <= 0) {
                throw new Exception("Number of subjects must be Greater than zero");
            }

            float[] marks = new float[numOfSubjects];

            for (int i = 0; i < numOfSubjects; i++) {
                System.out.print("Enter " + (i + 1) + "(out of 100) : ");
                float mark = sc.nextFloat();
                if (mark >= 0 && mark<=100) {
                    marks[i] = mark;
                } else {
                    throw new Exception("Subject Mark must be between 0 and 100");
                }
            }

            // total sum calculation
            for (float mark : marks) {
                total_sum += mark;
            }

            // average percentage calculation
            float average_percentage = (total_sum / numOfSubjects);
            System.out.printf("Total Marks: %.2f%n", total_sum);
            System.out.printf("Average Percentage: %.2f%n", average_percentage);

            // Grade calculation
            if (average_percentage > 80 && average_percentage <= 100) {
                System.out.println("Corresponding Grade is A");
            } else if (average_percentage > 60 && average_percentage <= 80) {
                System.out.println("Corresponding Grade is B");
            } else if (average_percentage > 40 && average_percentage <= 60) {
                System.out.println("Corresponding Grade is C");
            } else if (average_percentage >= 33 && average_percentage <= 40) {
                System.out.println("Corresponding Grade is D");
            } else {
                System.out.println("Corresponding Grade is F");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
