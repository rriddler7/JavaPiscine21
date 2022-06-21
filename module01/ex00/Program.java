package ex00;

public class Program {
    public static void main(String[] args) {
        User tom = new User ("Tom", 10000);
        User jerry = new User ("Jerry", 10);
        try {
            Transaction transaction = new Transaction(jerry, tom, -10000);
            System.out.println(transaction);
            Transaction transaction2 = new Transaction(jerry, tom, 10000);
            System.out.println(transaction2);
            Transaction transaction3 = new Transaction(jerry, tom, -11000);
            System.out.println(transaction3);
        }
        catch (Transaction.BalanceException e) {
            e.printStackTrace();
        }
    }
}