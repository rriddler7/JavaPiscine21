package ex03;

import java.util.UUID;

public class Transaction {

    enum Category {
        INCOME,
        OUTCOME
    }

    private UUID identifier;
    private User  recipient;
    private User sender;
    private Category transactionType;
    private Integer amount;

    private Transaction(User sender, User recipient, Transaction.Category transactionType, Integer amount) throws BalanceException {
        this.recipient = recipient;
        this.sender = sender;
        this.amount = amount;
        this.transactionType = transactionType;
        identifier = UUID.randomUUID();
    }

    public static Transaction createTransaction(User sender, User recipient, Transaction.Category transactionType, Integer amount) {
        if (transactionType == Transaction.Category.OUTCOME && amount < 0 && sender.getBalance() >= -amount) {
            sender.setBalance(sender.getBalance() + amount);
            recipient.setBalance(recipient.getBalance() - amount);
            Transaction newTransaction = new Transaction(sender, recipient, transactionType, amount);
            sender.getTransactions().add(newTransaction);
            recipient.getTransactions().add(newTransaction);
            return newTransaction;
        }
        else if (transactionType == Transaction.Category.INCOME && amount > 0 && recipient.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() + amount);
            recipient.setBalance(recipient.getBalance() - amount);
            Transaction newTransaction = new Transaction(sender, recipient, transactionType, amount);
            sender.getTransactions().add(newTransaction);
            recipient.getTransactions().add(newTransaction);
            return newTransaction;
        }
        else {
            throw new BalanceException ("Insufficient balance");
        }
    }

    public static class BalanceException extends RuntimeException {
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

    public Category getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Transaction.Category transactionType) {
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
        if (transactionType == Transaction.Category.OUTCOME) {
            return String.format("%s -> %s, %d, %s, %s", sender.getName(),
                    recipient.getName(), amount, transactionType, identifier);
        }
        else {
            return String.format("%s <- %s, %d, %s, %s", sender.getName(),
                    recipient.getName(), amount, transactionType, identifier);
        }
    }
}
