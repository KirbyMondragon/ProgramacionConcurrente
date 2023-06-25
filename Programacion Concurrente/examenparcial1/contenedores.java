package examenparcial1;

//Mostrar el nombre de 2 corredores y simular que corren una carrera de 30 km.
public class AnimalesWithThread extends Thread {
    String nombre;
    static AnimalesWithThread zorro;
    static AnimalesWithThread conejo;
    static AnimalesWithThread tortuga;

    public AnimalesWithThread(int prioridad, String nombre) {
        this.nombre = nombre;
        setPriority(prioridad);
    }

    public void run() {
        for (int c = 1; c <= 30; c++) {
            System.out.print(c + "mt ");
        }
        System.out.println("\n Llego a la meta " + nombre);
    }

    public static void main(String[] args) throws InterruptedException {
        conejo = new AnimalesWithThread(1, " conejo ");
        zorro = new AnimalesWithThread(5, " zorro ");
        tortuga = new AnimalesWithThread(8, " tortuga ");
        conejo.start();
        zorro.start();
        tortuga.start();
        conejo.join();
        zorro.join();
        tortuga.join();
    }
}