package hilosSincronizaciónEspera;

public class Hilo extends Thread {
    public void run() {
        System.out.println("Ejecutando " + Thread.currentThread().getName());
    }
}