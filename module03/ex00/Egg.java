package ex00;

//public class Egg extends Thread{
//    int amount;
//
//    Egg(int amount) {
//        this.amount = amount;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < this.amount; i++) {
//            System.out.println("Egg");
//        }
//    }
//}

public class Egg implements Runnable{
    int amount;

    Egg(int amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.amount; i++) {
            System.out.println("Egg");
        }
    }
}
