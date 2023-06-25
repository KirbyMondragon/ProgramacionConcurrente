package examenparcial1;


//Mostrar el nombre de 2 corredores y simular que corren una carrera de 30 km.
public class corredores extends Thread {
    String nombre;
    static corredores LaMole;
    static corredores SpiderPunk;

    public corredores(int prioridad, String nombre) {
        this.nombre = nombre;
        setPriority(prioridad);
    }

    public void run() {
        for (int c = 1; c <= 30; c++) {
            System.out.print(c + "km ");
        }
        System.out.println("\n Llego a la meta " + nombre);
    }

    public static void main(String[] args) throws InterruptedException {
        LaMole = new corredores(1, " La mole ");
        SpiderPunk = new corredores(5, " Spider punk ");
        LaMole.start();
        SpiderPunk.start();
        LaMole.join();
        SpiderPunk.join();
    }
}