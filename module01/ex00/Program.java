package ex00;

public class Program {
    public static void main(String[] args) {
        User tom = new User ("Tom", 10000);
        User jerry = new User ("Jerry", 10);
        Transaction transaction = Transaction.createTransaction(tom, jerry, Transaction.Category.OUTCOME, -5000);
        System.out.println(transaction);
        System.out.println("Tom " + tom.getBalance());
        System.out.println("Jerry " + jerry.getBalance());
        System.out.println("_____________");
        Transaction transaction2 = Transaction.createTransaction(tom, jerry, Transaction.Category.INCOME, 2000);
        System.out.println(transaction2);
        System.out.println("Tom " + tom.getBalance());
        System.out.println("Jerry " + jerry.getBalance());
        System.out.println("_____________");
        Transaction transaction3 = Transaction.createTransaction(tom, jerry, Transaction.Category.OUTCOME, -8000);
        System.out.println(transaction3);
        System.out.println("Tom " + tom.getBalance());
        System.out.println("Jerry " + jerry.getBalance());
    }
}
