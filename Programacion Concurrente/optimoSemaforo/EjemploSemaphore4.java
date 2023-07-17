package optimoSemaforo;
import java.util.concurrent.Semaphore;

public class EjemploSemaphore4 {
    public static final int CNT = 100000;
    public static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1); // Crear un semáforo con un "permiso" disponible

        // Crear tres hilos que incrementarán la variable x
        Thread thread1 = new Thread(() -> incrementValue(semaphore));
        Thread thread2 = new Thread(() -> incrementValue(semaphore));
        Thread thread3 = new Thread(() -> incrementValue(semaphore));

        // Iniciar los hilos
        thread1.start();
        thread2.start();
        thread3.start();

        // Esperar a que los hilos terminen
        thread1.join();
        thread2.join();
        thread3.join();

        // Verificar el resultado
        if (x == 3 * CNT) {
            System.out.println("El valor final de x es correcto: " + x);
        } else {
            System.out.println("Error en la concurrencia. Valor de x: " + x);
        }
    }
        //Elimine esta linea de codigo y agregaamos el incrementValue
    /*class TareaIncremento implements Runnable {
        private final Semaphore semaphore;
    
        public TareaIncremento(Semaphore semaphore) {
            this.semaphore = semaphore;
            */

    // Método para incrementar el valor de x utilizando el semáforo
    public static void incrementValue(Semaphore semaphore) {
        try {
            for (int i = 0; i < CNT; i++) {
                semaphore.acquire(); // Adquirir el permiso del semáforo
                x++; // Incrementar la variable x
                semaphore.release(); // Liberar el permiso del semáforo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}