package semaphoro;

import java.util.concurrent.*;

public class Semaphore {
    private int p;// variable para asignar el permiso de acceso a la tarea

    public Semaphore() {// constructor vacio para crear la instancia
    }

    public Semaphore(int p) {// constructor con parametros para asignar el permiso
        // para la tarea al crear una instancia
        this.p = p;
    }
    // funciones acquire y release

    public void acquire() throws InterruptedException {
        acquire(1);// metodo con excepcion para mantener la asignacio del valor
        // inicial para el acceso de posterior al permiso
    }

    public void acquire(int n) throws InterruptedException {
        // metodo para solcitar el valor binario para dar acceso a la tarea
        // por hilo
    }

    public void release() {
        release(1);// metodo para determinar el proceso de lock para tiempo
        // de espera para asignar permiso de acceso para liberar
    }

    public void release(int n) {
        // metodo para solcitar el valor binario para definir el lock a la tarea
        // por hilo para liberar
    }
}