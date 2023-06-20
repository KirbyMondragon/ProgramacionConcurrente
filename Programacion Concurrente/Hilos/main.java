package Hilos;
public class main {
  public static void main(String[] args) {
    Thread hilo = new Thread(new ejemplo1("Este es Hilo1"));
    Thread hilo2 = new Thread(new ejemplo1("Este es Hilo2"));
    Thread hilo3 = new Thread(new ejemplo1("Este es Hilo3"));
    Thread hilo4 = new Thread(new ejemplo1("Este es Hilo4"));
    hilo.start();
    hilo2.start();
    hilo3.start();
    hilo4.start();
  }
}
