package ex01;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1 && args[0].startsWith("--count=")) {
            System.out.println("Wrong arguments!");
            System.exit(-1);
        }

        int amount = 0;
        try {
            amount = Integer.parseInt(args[0].substring(8));
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        Thread eggThread = new Thread(new PC("Egg", amount));
        Thread henThread = new Thread(new PC("Hen", amount));

        eggThread.start();
        henThread.start();

            eggThread.join();
            henThread.join();

        for (int i = 0; i < amount; i++) {
            System.out.println("Human");
        }
    }
}
