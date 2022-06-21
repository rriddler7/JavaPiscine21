package ex00;

import java.util.UUID;

public class Transaction {

    enum Category {
        INCOME,
        OUTCOME
    }

    private UUID identifier;
    private User  recipient;
    private User sender;
    private Category transaction;
    private Integer amount;

    public Transaction(User recipient, User sender, Integer amount) throws BalanceException {
        this.recipient = recipient;
        this.sender = sender;
        this.amount = amount;
        if (amount < 0) {
            setTransaction(Category.OUTCOME);
        }
        else {
            setTransaction(Category.INCOME);
        }
        identifier = UUID.randomUUID();

        if (sender.getBalance() < 0 || sender.getBalance() < -amount) {
            throw new BalanceException("Insufficient balance");
        }
        else {
            sender.setBalance(sender.getBalance() + amount);
            recipient.setBalance(recipient.getBalance() - amount);
        }
    }

    class BalanceException extends Exception {
        public BalanceException(String message) {
            super(message);
        }
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Category getTransaction() {
        return transaction;
    }

    public void setTransaction(Category transaction) {
        this.transaction = transaction;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s, %d, %s", sender.getName(), recipient.getName(), amount, transaction);
    }
}


