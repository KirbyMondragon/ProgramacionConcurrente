package TablasConRetardo;

public class Main2 {
  public static void main(String[] args) {
    Thread hilo8 = new Thread(new TablaMultiplicar(8, 1500));
    Thread hilo5 = new Thread(new TablaMultiplicar(5, 1500));

    hilo8.start();
    hilo5.start();
  }
}