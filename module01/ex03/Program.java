package ex03;

public class Program {
    public static void main(String[] args) throws ex03.UserArrayList.UserNotFoundException {
        UserArrayList userList = new UserArrayList();

        User bob = new User("Bob", 10000);
        User jack = new User("Jack", 10);

        Transaction transaction = null;
        try {
            transaction = new Transaction(jack, bob, -9000);
            System.out.println(transaction);
            Transaction transaction2 = new Transaction(jack, bob, 10000);
            System.out.println(transaction2);
            Transaction transaction3 = new Transaction(jack, bob, -1000);
            System.out.println(transaction3);
        }
        catch (Transaction.BalanceException e) {
            e.printStackTrace();
        }
        System.out.println(jack.getTransactions());
        System.out.println(bob.getTransactions());
        bob.getTransactions().remove(transaction.getIdentifier());
        System.out.println(jack.getTransactions());
        System.out.println(bob.getTransactions());
    }
}
