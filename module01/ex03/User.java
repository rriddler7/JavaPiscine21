package ex03;

public class User {
    private Integer id;
    private String name;
    private Integer balance;
    private TransactionsList transactions;

    public User(String name, Integer balance) {
        this.name = name;
        if (balance > 0)
            this.balance = balance;
        else
            this.balance = 0;
        this.id = UserIdsGenerator.getInstance().generateId();
        this.transactions = new TransactionsLinkedList();
    }

    public Integer getIdentifier() {
        return id;
    }

    public void setIdentifier(Integer identifier) {
        this.id = identifier;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public TransactionsList getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "ID " + id + ", name, " + name + " , balance " + balance;
    }
}

