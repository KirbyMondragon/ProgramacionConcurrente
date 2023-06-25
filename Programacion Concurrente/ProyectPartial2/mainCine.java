package ProyectPartial2;
public class mainCine {
    public static void main(String[] args) {
        // Crear una instancia de la clase Cine con 10 asientos
        Cine cine = new Cine(10);

        // Crear clientes
        Cliente cliente1 = new Cliente(cine, 1);
        Cliente cliente2 = new Cliente(cine, 2);
        Cliente cliente3 = new Cliente(cine, 3);

        // Mostrar el estado inicial de los asientos
        cine.mostrarEstadoAsientos();

        // Crear hilos para los clientes
        Thread hiloCliente1 = new Thread(cliente1);
        Thread hiloCliente2 = new Thread(cliente2);
        Thread hiloCliente3 = new Thread(cliente3);

        // Iniciar los hilos de reserva de asientos
        hiloCliente1.start();
        hiloCliente2.start();
        hiloCliente3.start();

        try {
            // Esperar a que los hilos finalicen
            hiloCliente1.join();
            hiloCliente2.join();
            hiloCliente3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostrar el estado final de los asientos
        cine.mostrarEstadoAsientos();
    }
}
