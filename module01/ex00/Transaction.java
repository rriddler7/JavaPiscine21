package ex00;

import java.util.UUID;

public class Transaction {

    public enum Category {
        INCOME,
        OUTCOME
    }

    private UUID identifier;
    private User  recipient;
    private User sender;
    private Category transactionType;
    private Integer amount;

    private Transaction(User sender, User recipient, Category transactionType, Integer amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.transactionType = transactionType;
        identifier = UUID.randomUUID();
    }

    public static Transaction createTransaction(User sender, User recipient, Category transactionType, Integer amount) {
        if (transactionType == Category.OUTCOME && amount < 0 && sender.getBalance() >= -amount) {
            sender.setBalance(sender.getBalance() + amount);
            recipient.setBalance(recipient.getBalance() - amount);
            return new Transaction(sender, recipient, transactionType, amount);
        }
        else if (transactionType == Category.INCOME && amount > 0 && recipient.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() + amount);
            recipient.setBalance(recipient.getBalance() - amount);
            return new Transaction(sender, recipient, transactionType, amount);
        }
        else {
            System.err.println("Insufficient balance");
            return null;
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

    public Category getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Category transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        if (transactionType == Category.OUTCOME) {
            return String.format("%s -> %s, %d, %s, %s", sender.getName(),
                    recipient.getName(), amount, transactionType, identifier);
        }
        else {
            return String.format("%s <- %s, %d, %s, %s", sender.getName(),
                    recipient.getName(), amount, transactionType, identifier);
        }
    }
}


