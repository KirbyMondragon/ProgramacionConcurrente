package ProgramaIntegradorHilos;
public class MainRunnable implements Runnable {
    private Cajero cajero;
    private Cliente cliente;
    private long initialTime;

    public MainRunnable(Cliente cliente, Cajero cajero, long initialTime) {
        this.cajero = cajero;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 3, 4, 1, 2 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 1, 2, 1 });
        Cajero cajero1 = new Cajero(" Cajero 1");
        Cajero cajero2 = new Cajero(" Cajero 2");
        long initialTime = System.currentTimeMillis();
        Runnable proceso1 = new MainRunnable(cliente2, cajero2, initialTime);
        Runnable proceso2 = new MainRunnable(cliente1, cajero1, initialTime);
        new Thread(proceso1).start();
        new Thread(proceso2).start();
    }

    @Override
    public void run() {
        this.cajero.procesarCompra(this.cliente, this.initialTime);

    }
}