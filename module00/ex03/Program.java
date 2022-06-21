package ex03;

import java.util.Scanner;

public class Program {
    private static int minGrade(Scanner input) {
        int grade;
        int mingrade = 9;
        int tests = 0;

        while (tests < 5) {
            if (!input.hasNextInt()) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            grade = input.nextInt();
            if (grade < 1 || grade > 9) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            mingrade = (grade < mingrade) ? grade : mingrade;
            tests++;
        }
        return mingrade;
    }

    private static void displayGrade(int weeknmb, long grade) {
        System.out.printf("Week %2d ", weeknmb);
        for (int i = 0; i < grade; i++) {
            System.out.print("=");
        }
        System.out.println(">");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int weeks = 0;
        long grades = 0;
        long grade;

        while (weeks < 18) {
            String inputData = input.next();
            if ("42".equals(inputData)) {
                break;
            }
            else if ("Week".equals(inputData) && input.hasNextInt()) {
                int weeknmb = input.nextInt();

                if (weeknmb != weeks + 1) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                grade = minGrade(input);
                for (int i = 0; i < weeks; i++) {
                    grade = grade * 10;
                }
                weeks++;
                grades = grades + grade;
            }
            else {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
        }
        for (int weeknmb = 1; grades != 0; weeknmb++, grades = grades / 10) {
            displayGrade(weeknmb, grades % 10);
        }
    }
}
