import java.util.concurrent.Semaphore;
//Explicacion al Final Kevin Mondragon y Victor Jimenez
public class BirdStoreMT {
    public static void main(String[] args) {
        Semaphore semaphorePlate = new Semaphore(3); // Semáforo para controlar el acceso al plato (3 permisos)
        Semaphore semaphoreSwing = new Semaphore(1); // Semáforo para controlar el acceso al columpio (1 permiso)

        Thread thread1 = new Thread(new Canary(semaphorePlate, semaphoreSwing, " (1) Denisse"));
        Thread thread2 = new Thread(new Canary(semaphorePlate, semaphoreSwing, " (2) Arturo"));
        Thread thread3 = new Thread(new Canary(semaphorePlate, semaphoreSwing, " (3) Romina"));
        Thread thread4 = new Thread(new Canary(semaphorePlate, semaphoreSwing, " (4) Nicol"));
        Thread thread5 = new Thread(new Canary(semaphorePlate, semaphoreSwing, " (5) Piter"));
        Thread thread6 = new Thread(new Canary(semaphorePlate, semaphoreSwing, " (6) Spiterman"));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

class Canary implements Runnable {
    public final Semaphore semaphorePlate;
    public final Semaphore semaphoreSwing;
    public final String canaryName;

    public Canary(Semaphore semaphorePlate, Semaphore semaphoreSwing, String canaryName) {
        this.semaphorePlate = semaphorePlate;
        this.semaphoreSwing = semaphoreSwing;
        this.canaryName = canaryName;
    }

    @Override
    public void run() {
        try {
            // Acceder al plato (solo pueden haber 3 canarios a la vez)
            semaphorePlate.acquire();
            System.out.println("Canary " + canaryName + " está comiendo del plato");

            // Acceder al columpio (solo puede haber 1 canario a la vez)
            semaphoreSwing.acquire();
            System.out.println("Canary " + canaryName + " está columpiándose");

            // Simular tiempo de actividad en el columpio
            Thread.sleep(2000);

            // Liberar el acceso al plato y al columpio
            semaphorePlate.release();
            semaphoreSwing.release();

            System.out.println("Canary " + canaryName + " ha terminado su rutina y se va a descansar");
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


