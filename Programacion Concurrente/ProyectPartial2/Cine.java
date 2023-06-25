package ProyectPartial2;

import java.util.concurrent.locks.ReentrantLock;

public class Cine {
    private ReentrantLock lock;
    private boolean[] asientos;

    public Cine(int numAsientos) {
        lock = new ReentrantLock();
        asientos = new boolean[numAsientos];
    }

    public int reservarAsiento() {
        lock.lock();
        try {
            for (int i = 0; i < asientos.length; i++) {
                if (!asientos[i]) {
                    asientos[i] = true;
                    return i; // Devuelve el número de asiento reservado
                }
            }
        } finally {
            lock.unlock();
        }
        return -1; // Si no hay asientos disponibles
    }

    public void liberarAsiento(int numAsiento) {
        lock.lock();
        try {
            if (numAsiento >= 0 && numAsiento < asientos.length) {
                asientos[numAsiento] = false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void mostrarEstadoAsientos() {
        System.out.println("Estado de los asientos:");
        for (int i = 0; i < asientos.length; i++) {
            String estado = asientos[i] ? "Ocupado" : "Disponible";
            System.out.println("Asiento " + i + ": " + estado);
        }
        System.out.println();
    }
}

