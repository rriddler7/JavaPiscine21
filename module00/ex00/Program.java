package ex00;

public class Program {
    public static void main(String[] args) {
        int number = 479598;
        int sumdigit = 0;

        sumdigit = number % 10;
        number = number / 10;
        sumdigit += number % 10;
        number = number / 10;
        sumdigit += number % 10;
        number = number / 10;
        sumdigit += number % 10;
        number = number / 10;
        sumdigit += number % 10;
        number = number / 10;
        sumdigit += number % 10;

        System.out.println(sumdigit);
    }
}
