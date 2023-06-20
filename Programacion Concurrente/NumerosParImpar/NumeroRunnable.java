package NumerosParImpar;

// Interfaz para imprimir números
interface NumeroRunnable extends Runnable {
    void imprimirNumeros();
}

// Clase para imprimir números pares
class ParRunnable implements NumeroRunnable {
    private int inicio;
    private int fin;

    public ParRunnable(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        imprimirNumeros();
    }

    @Override
    public void imprimirNumeros() {
        for (int i = inicio; i <= fin; i += 2) {
            System.out.println("Hilo 1, numeros par" + i);
        }
    }
}