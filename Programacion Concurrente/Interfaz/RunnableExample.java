package Interfaz;

public class RunnableExample implements Runnable {
    
    @Override
    public void run() {
        // Código que se ejecutará en el hilo
        System.out.println("El hilo se está ejecutando");
    }
    
    public static void main(String[] args) {
        // Crear una instancia de la clase que implementa Runnable
        RunnableExample runnable = new RunnableExample();
        
        // Crear un objeto Thread pasando la instancia de Runnable
        Thread thread = new Thread(runnable);
        
        // Iniciar la ejecución del hilo
        thread.start();
        
        // El programa principal sigue ejecutándose mientras el hilo corre en paralelo
        System.out.println("El programa principal sigue ejecutándose");
    }
}
