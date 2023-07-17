package semaphoro;

import java.util.concurrent.Semaphore;

public class tiendaPajaros {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // Crear un semáforo con una sola "permiso" disponible

        // Crear tres hilos que intentarán adquirir el permiso del semáforo
        Thread thread1 = new Thread(new Tarea(semaphore, "(1) Canario Victor "));
        Thread thread2 = new Thread(new Tarea(semaphore, "(2) Canario Romina"));
        Thread thread3 = new Thread(new Tarea(semaphore, "(3) Canario Nicol"));
        Thread thread4 = new Thread(new Tarea(semaphore, "(4) Canario Denisse"));
        // Iniciar los hilos
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class Rutina implements Runnable {
    private final Semaphore semaphore;
    private final String threadName;

    public Rutina(Semaphore semaphore, String threadName) {
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + " está esperando para poder comer");
            semaphore.acquire(); // Adquirir el permiso del semáforo

            System.out.println(threadName + " esta comiendo muy feliz");
            // Realizar la tarea protegida por el semáforo
            Thread.sleep(2000); // Simular un trabajo que toma 2 segundos

            System.out.println(threadName + " ha completado la tarea y está liberando el permiso.");
            semaphore.release(); // Liberar el permiso del semáforo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}