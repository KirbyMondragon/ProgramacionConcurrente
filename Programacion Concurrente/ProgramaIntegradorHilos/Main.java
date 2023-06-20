package ProgramaIntegradorHilos;
/*PROGRAMA PARA SIMULAR EL PROCESO
 * DE VENTA DE ARTICULOS
 */
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 3, 4, 1, 2 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 1, 2, 1 });
        /*
         * Cajero cajero = new Cajero("Cajero 1");
         * Cajero cajero1 = new Cajero("Cajero 2");
         * long initialTime = System.currentTimeMillis();
         * cajero.procesarCompra(cliente2, initialTime);
         * cajero1.procesarCompra(cliente1, initialTime);
         */
        long initialTime = System.currentTimeMillis();
        CajeroThread cajero1 = new CajeroThread(" Cajero 1", cliente1, initialTime);
        CajeroThread cajero2 = new CajeroThread(" Cajero 2", cliente2, initialTime);
        cajero1.start();
        cajero2.start();
    }

}
