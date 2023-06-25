package Examen2Parcial1;


//Mostrar el nombre de 2 corredores y simular que corren una carrera de 30 km.
public class empleados extends Thread {
    String nombre;
    int dia;
    int hora;
    static empleados LaMole;
    static empleados SpiderPunk;

    public empleados(int prioridad, String nombre, int dia, int hora) {
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
        setPriority(prioridad);
    }

    public void run() {
        if(hora <= 8){
        System.out.println("Hoy es "+dia +" y estas a tiempo " + nombre );
    }
    else
    {
        System.out.println("Llegaste tarde" + nombre + "las " + hora + ":00 horas" + "es tarde");
    }
    }

    public static void main(String[] args) throws InterruptedException {
        LaMole = new empleados(1, " La mole ", 22, 8);
        SpiderPunk = new empleados(1, " SpiderPunk ", 22, 10);
        LaMole.start();
        SpiderPunk.start();
        LaMole.join();
        SpiderPunk.join();
    }
}