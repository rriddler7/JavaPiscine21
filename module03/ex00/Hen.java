package ex00;

//public class Hen extends Thread{
//    int amount;
//
//    Hen(int amount) {
//        this.amount = amount;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < this.amount; i++) {
//            System.out.println("Hen");
//        }
//    }
//}

public class Hen implements Runnable{
    int amount;

    Hen(int amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.amount; i++) {
            System.out.println("Hen");
        }
    }
}
