package semaphoro;
import java.util.concurrent.Semaphore;

public class EjemploSemaphore2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1); // Crear un semáforo con una sola "permiso" disponible

        // Crear tres hilos que intentarán adquirir el permiso del semáforo
        Thread thread1 = new Thread(new Tarea(semaphore, "Thread 1"));
        Thread thread2 = new Thread(new Tarea(semaphore, "Thread 2"));
        Thread thread3 = new Thread(new Tarea(semaphore, "Thread 3"));

        // Iniciar los hilos
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Tarea implements Runnable {
    private final Semaphore semaphore;
    private final String threadName;

    public Tarea(Semaphore semaphore, String threadName) {
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + " está esperando para adquirir el permiso del semáforo.");
            semaphore.acquire(); // Adquirir el permiso del semáforo

            System.out.println(threadName + " ha adquirido el permiso del semáforo.");
            // Realizar la tarea protegida por el semáforo
            Thread.sleep(2000); // Simular un trabajo que toma 2 segundos

            System.out.println(threadName + " ha completado la tarea y está liberando el permiso.");
            semaphore.release(); // Liberar el permiso del semáforo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}