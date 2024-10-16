package CodeAlphaProject;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] grades = new int[5];


        int[] currentGrades = new int[]{85, 92, 78, 95, 88};

        System.out.println("Welcome to the Student Grade Tracker!");

        int choice;
        do {

            System.out.println("\nCurrent Grades:");
            for (int grade : currentGrades) {
                System.out.print(grade + " ");
            }
            System.out.println();


            System.out.println("\nOptions:");
            System.out.println("1. Add a new grade");
            System.out.println("2. Modify an existing grade");
            System.out.println("3. Display current grades");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    addNewGrade(currentGrades);
                    break;
                case 2:

                    modifyGrade(currentGrades);
                    break;
                case 3:

                    break;
                case 4:

                    System.out.println("Exiting the Student Grade Tracker!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }


    private static void addNewGrade(int[] grades) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the new grade: ");
        int newGrade = scanner.nextInt();


        if (grades.length == 0) {
            grades = new int[1];
        } else if (grades.length == countNonZeroElements(grades)) {
            int[] newGrades = new int[grades.length * 2]; 
            System.arraycopy(grades, 0, newGrades, 0, grades.length);
            grades = newGrades;
        }


        int index = 0;
        while (grades[index] != 0) {
            index++;
        }
        grades[index] = newGrade;

        System.out.println("Grade added successfully!");
    }

    private static void modifyGrade(int[] grades) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the index of the grade to modify (0-" + (grades.length - 1) + "): ");
        int index = scanner.nextInt();

        if (index < 0 || index >= grades.length) {
            System.out.println("Invalid index. Please try again.");
            return;
        }

        System.out.print("Enter the new grade: ");
        int newGrade = scanner.nextInt();

        grades[index] = newGrade;
        System.out.println("Grade modified successfully!");
    }

    private static int countNonZeroElements(int[] arr) {
        int count = 0;
        for (int element : arr) {
            if (element != 0) {
                count++;
            }
        }
        return count;
    }
}
