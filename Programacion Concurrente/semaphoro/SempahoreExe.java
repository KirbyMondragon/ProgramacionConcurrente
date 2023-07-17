package semaphoro;

public class SempahoreExe {
    public static final int CNT = 100000;
    public static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        SempahoreExe test = new SempahoreExe();
        test.go();
    }

    public void go() throws InterruptedException {
        Semaphore s = new Semaphore();
        Thread t1 = new Objeto(s);
        Thread t2 = new Objeto(s);
        Thread t3 = new Objeto(s);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        if (x == 1 * CNT) {
            System.out.println("OK");
        } else {
            System.out.println("Error de carrera!");
        }
    }
}