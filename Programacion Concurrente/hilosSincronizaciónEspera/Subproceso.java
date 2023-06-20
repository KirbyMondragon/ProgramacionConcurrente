package hilosSincronizaciónEspera;

public class Subproceso {
    public static void main(String[] args) {
        Hilo h1 = new Hilo();
        Hilo h2 = new Hilo();

        h1.setName("Hilo 1");
        h2.setName("Hilo 2");

        h1.setPriority(10);
        h2.setPriority(1);

        h1.start();
        h2.start();
    }
}
