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

        final ProducerConsumer pc = new ProducerConsumer();

        Thread eggThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread henThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        Thread eggThread = new Thread(new Egg(amount));
//        Thread henThread = new Thread(new Hen(amount));

        eggThread.start();
        henThread.start();

        try {
            eggThread.join();
            henThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < amount; i++) {
            System.out.println("Human");
        }
    }
}
