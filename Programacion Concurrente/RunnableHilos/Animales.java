package RunnableHilos;

public class Animales implements Runnable {
    private String nombre;
    private Thread thread;

    public Animales(int prioridad, String nombre) {
        this.nombre = nombre;
        thread = new Thread(this);
        thread.setPriority(prioridad);
    }

    public void run() {
        try {
            for (int c = 1; c <= 30; c++) {
                System.out.print(c + "mt ");
                Thread.sleep(100); // Agrega un pequeño retraso para simular el movimiento
            }
            System.out.println("\nLlego a la meta " + nombre);
        } catch (InterruptedException e) {
            System.out.println("El hilo " + nombre + " fue interrumpido.");
        }
    }

    public static void main(String[] args) {
        Animales conejo = new Animales(1, "conejo");
        Animales zorro = new Animales(5, "zorro");
        Animales tortuga = new Animales(8, "tortuga");

        conejo.thread.start();
        zorro.thread.start();
        tortuga.thread.start();
    }
}