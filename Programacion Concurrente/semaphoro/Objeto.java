package semaphoro;

public class Objeto extends Thread {
    private final Semaphore semaphore;

    public Objeto(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < SempahoreExe.CNT; i++) {
                semaphore.acquire();
                i = i + 1;
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}