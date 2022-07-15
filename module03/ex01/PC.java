package ex01;

public class PC implements Runnable{
    private String name;
    private int amount;
    static String word;

    public PC(String name, int amount) {
        this.name = name;
        this.amount = amount;

    }
    public void run() {
        while (amount > 0) {
            synchronized (PC.class) {
                if (name == word) {
                    try {
                        PC.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(this.name);
                word = name;
                amount--;
                PC.class.notify();
            }
        }
    }
}
