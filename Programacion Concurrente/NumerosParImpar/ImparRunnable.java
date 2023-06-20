package NumerosParImpar;

// Clase para imprimir números impares
class ImparRunnable implements NumeroRunnable {
    private int inicio;
    private int fin;

    public ImparRunnable(int inicio, int fin) {
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
            System.out.println("Hilo 2 numero impar: "+ i);
        }
    }
}