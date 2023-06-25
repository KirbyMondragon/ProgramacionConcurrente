package Interfaz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ControladorHilos {
    public static void main(String[] args) {
        // Crear un ExecutorService con un tamaño máximo de hilos
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Crear instancias de la clase TareaHilo e iniciar los hilos
        for (int i = 0; i < 10; i++) {
            // Crear una nueva instancia de TareaHilo con un nombre único
            Runnable tareaHilo = new TareaHilo("Hilo " + (i + 1));
            // Ejecutar la tarea en el ExecutorService
            executor.execute(tareaHilo);
        }

        // Apagar el ExecutorService cuando haya terminado de ejecutar las tareas
        executor.shutdown();
    }
}

// Clase que implementa la interfaz Runnable para representar una tarea que realizará un hilo
class TareaHilo implements Runnable {
    private final String nombreHilo;

    public TareaHilo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        try {
            System.out.println("Iniciando " + nombreHilo);
            // Simular alguna tarea que realiza el hilo
            Thread.sleep(2000);
            System.out.println("Finalizando " + nombreHilo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//ngresar el nombre de dos usuarios, el día y la hora que ingreso
//a su centro de labores, e indicar si llego temprano o tarde, cabe
//señalar que la hora de ingreso es a las 8:00.