package ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Node first = new Node();
    private Node last = new Node();
    private int count;

    public static class Node {
        private Node prev;
        private Node next;
        Transaction transaction;
    }

    public TransactionsLinkedList() {
        first.next = last;
        last.prev = first;
    }

    @Override
    public void add(Transaction transaction) {
        Node addNode = new Node();
        addNode.transaction = transaction;

        Node lastNode = last.prev;
        lastNode.next = addNode;
        addNode.prev = lastNode;
        last.prev = addNode;
        addNode.next = last;
        count++;
    }

    @Override
    public void remove(UUID id) throws TransactionNotFoundException {
        Node removeNode = first.next;
        while (removeNode != last) {
            if (id.equals(removeNode.transaction.getIdentifier())) {
                Node parent = removeNode.prev;
                Node child = removeNode.next;
                parent.next = child;
                child.prev = parent;
                count--;
                return;
            }
            removeNode = removeNode.next;
        }
        throw new TransactionNotFoundException("Transaction id " + id + "can not found");
    }

    @Override
    public Transaction[] toArray(){
        Transaction [] transactionsArray = new Transaction[count];
        Node present = first;
        for (int i = 0; i < count; i++) {
            present = present.next;
            transactionsArray[i] = present.transaction;
        }
        return transactionsArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node present = first;
        for (int i = 0; i < count; i++) {
            present = present.next;
            sb.append(present.transaction.toString()).append(", ");
        }
        if (count > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    public class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException(String message) {
            super(message);
        }
    }
}
