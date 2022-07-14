package ex00;

//public class Program {
//    public static void main(String[] args) throws InterruptedException {
//        if (args.length != 1 && args[0].startsWith("--count=")) {
//            System.out.println("Wrong arguments!");
//            System.exit(-1);
//        }
//
//        int amount = 0;
//        try {
//            amount = Integer.parseInt(args[0].substring(8));
//        } catch (NumberFormatException nfe) {
//            System.out.println("NumberFormatException: " + nfe.getMessage());
//        }
//
//        Egg eggThread = new Egg(amount);
//        Hen henThread = new Hen(amount);
//
//        eggThread.start();
//        henThread.start();
//
//        try {
//            eggThread.join();
//            henThread.join();
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i < amount; i++) {
//            System.out.println("Human");
//        }
//    }
//}

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

        Thread eggThread = new Thread(new Egg(amount));
        Thread henThread = new Thread(new Hen(amount));

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
