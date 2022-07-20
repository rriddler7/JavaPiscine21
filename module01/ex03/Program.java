package ex03;

public class Program {
    public static void main(String[] args) throws TransactionsLinkedList.TransactionNotFoundException {
        UserArrayList userList = new UserArrayList();

        User tom = new User("Tom", 10000);
        User jerry = new User("Jerry", 10);
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
        Transaction transaction3 = Transaction.createTransaction(tom, jerry, Transaction.Category.OUTCOME, -6000);
        System.out.println(transaction3);
        System.out.println("Tom " + tom.getBalance());
        System.out.println("Jerry " + jerry.getBalance());

        
        System.out.println(tom.getTransactions());
        System.out.println(jerry.getTransactions());
        tom.getTransactions().remove(transaction.getIdentifier());
        System.out.println(tom.getTransactions());
        System.out.println(jerry.getTransactions());
    }
}
