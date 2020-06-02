package lesson4;

public class HomeWork {
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        HomeWork w = new HomeWork();
        Thread t1 = new Thread(w::printA);
        Thread t2 = new Thread(w::printB);
        Thread t3 = new Thread(w::printC);
        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'A') {
                    wait();
                }
                System.out.print("A");
                currentLetter = 'B';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'B') {
                    wait();
                }
                System.out.print("B");
                currentLetter = 'C';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'C') {
                    wait();
                }
                System.out.print("C");
                currentLetter = 'A';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

