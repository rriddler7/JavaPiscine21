//package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input number: ");
        if (!input.hasNextInt()) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        int nmb = input.nextInt();
        if (nmb <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        int divider = 2;
        int iterator = 1;
        while (divider <= nmb / divider) {

            if (nmb % divider == 0) {
                System.out.println("false " + iterator);
                return ;
            }
            iterator++;
            divider++;
        }
        System.out.println("true " + iterator);
    }
}
