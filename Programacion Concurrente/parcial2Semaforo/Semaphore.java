package parcial2Semaforo;
import java.util.concurrent.*;


public class Semaphore { // definimos una variable que define
    // la asignacion de un permiso (,string,double puede ser cualquier tipo)
    private int variable;


    public Semaphore(int v) {// el constructor recibe un parametro
        this.variable = v;
    }


    // definimos el metodo acquire
    public void acquire(int variable) throws InterruptedException {// metodo sin parametro
       
    }


    public void acquire() {// metodo con parametros
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
            acquire();
        }
    }


    public void release(int n) {
        release(n);
    }
}