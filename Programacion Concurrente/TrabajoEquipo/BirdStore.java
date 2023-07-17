package TrabajoEquipo;

import java.util.concurrent.Semaphore;
//La explicacion esta al final 
public class BirdStore {
    public static void main(String[] args) {
        Semaphore semaphorePlate = new Semaphore(3); // Semáforo para controlar el acceso al plato (3 permisos)
        Semaphore semaphoreSwing = new Semaphore(1); // Semáforo para controlar el acceso al columpio (1 permiso)

        for (int i = 1; i <= 6; i++) {
            Thread thread = new Thread(new Canary(semaphorePlate, semaphoreSwing, i));
            thread.start();
        }
    }
}
//Kevin Mondragon y Victor Jimenez ISW-22
class Canary implements Runnable {
    private final Semaphore semaphorePlate;
    private final Semaphore semaphoreSwing;
    private final int canaryId;

    public Canary(Semaphore semaphorePlate, Semaphore semaphoreSwing, int canaryId) {
        this.semaphorePlate = semaphorePlate;
        this.semaphoreSwing = semaphoreSwing;
        this.canaryId = canaryId;
    }

    @Override
    public void run() {
        try {
            // Acceder al plato (solo pueden haber 3 canarios a la vez)
            semaphorePlate.acquire();
            System.out.println("Canary " + canaryId + " está comiendo del plato");

            // Acceder al columpio (solo puede haber 1 canario a la vez)
            semaphoreSwing.acquire();
            System.out.println("Canary " + canaryId + " está columpiándose");

            // Simular tiempo de actividad en el columpio
            Thread.sleep(2000);

            // Liberar el acceso al plato y al columpio
            semaphorePlate.release();
            semaphoreSwing.release();

            System.out.println("Canary " + canaryId + " ha terminado su rutina y se va a descansar");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*Imagina que los semáforos son como controladores de tráfico en una calle.
 Hay uno que permite que solo tres canarios puedan acceder al plato de alpiste al mismo tiempo,
  y otro que permite que solo un canario pueda estar en el columpio a la vez.

Cada canario tiene una tarea específica que debe realizar.
 Primero, el canario solicita permiso para acceder al plato de alpiste.
 Una vez que obtiene el permiso, puede comer del plato. Luego, solicita permiso para usar el columpio.
 Después de un tiempo en el columpio, el canario finaliza su actividad y libera los permisos
 para que otros canarios puedan usarlos.

Esta forma de organización garantiza que solo tres canarios puedan comer del plato de alpiste al mismo
tiempo y que solo un canario pueda estar en el columpio. Evita que los canarios se choquen entre sí o que
haya problemas por querer usar los mismos lugares al mismo tiempo. */


