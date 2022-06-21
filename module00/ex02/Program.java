package ex02;

import java.util.Scanner;

public class Program {
    private static long sumdigit(long number) {
        long sumdigit = 0;

        while (number > 0) {
            sumdigit += number % 10;
            number /= 10;
        }
        return(sumdigit);
    }

    private static long primenmb(long sumdigit) {
        int divider = 2;
        while (divider <= sumdigit / divider) {
            if (sumdigit % divider == 0) {
                return(0);
            }
            divider++;
        }
        return(sumdigit);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long requestnmb = 0;
        int coffeerequest = 0;
        long sumdigit = 0;
        while (input.hasNextLong()) {
            requestnmb = input.nextLong();
            if (requestnmb == 42)
                break;
            sumdigit = sumdigit(requestnmb);
            if (sumdigit > 1 && primenmb(sumdigit) > 0)
                coffeerequest++;
        }
        System.out.println("Count of coffee-request - " + coffeerequest);
    }
}
