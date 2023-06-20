package ProgramaIntegradorHilos;
public class CajeroThread extends Thread {
    String nombre;
    Cliente cliente;
    long initialTime;

    public CajeroThread(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public void run() {
        System.out.println("El cajero" + this.nombre + " comienza a procesar"
                + "la compra del cliente" + cliente.getNombre() + " en el tiempo "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarSegundos(cliente.getCarroCompra()[i]);
            System.out.println("procesado el producto " + (i + 1) +
                    "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 +
                    " seg");
        }
        System.out.println("El cajero " + this.nombre + " ha terminado de procesar" +
                cliente.getNombre() + " en el tiempo: " +
                (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");

    }

    private void esperarSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            
            Thread.currentThread().interrupt();
        }
    }
}