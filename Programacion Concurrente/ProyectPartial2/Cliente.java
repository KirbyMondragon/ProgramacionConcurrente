package ProyectPartial2;

public class Cliente implements Runnable {
    private Cine cine;
    private int numCliente;

    public Cliente(Cine cine, int numCliente) {
        this.cine = cine;
        this.numCliente = numCliente;
    }

    @Override
    public void run() {
        int numAsiento = cine.reservarAsiento();
        if (numAsiento != -1) {
            System.out.println("Cliente " + numCliente + ": Asiento " + numAsiento + " reservado.");
        } else {
            System.out.println("Cliente " + numCliente + ": No hay asientos disponibles.");
        }
    }
}
