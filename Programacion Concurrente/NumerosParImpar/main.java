package NumerosParImpar;

public class main {
    public static void main(String[] args) {
        NumeroRunnable parRunnable1 = new ParRunnable(2, 10);
        
        NumeroRunnable imparRunnable1 = new ImparRunnable(1, 9);
        

        Thread parThread1 = new Thread(parRunnable1);
      
        Thread imparThread1 = new Thread(imparRunnable1);
       

        parThread1.start();
        
        imparThread1.start();
        
    }
}