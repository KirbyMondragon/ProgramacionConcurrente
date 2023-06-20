package TablasConRetardo;
class TablaMultiplicar implements Runnable {
  public int numero;
  public int retardo;

  public TablaMultiplicar(int numero, int retardo) {
    this.numero = numero;
    this.retardo = retardo;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("La tabla del " + numero + " es: " + numero + " * " + i + " = " + (numero * i));

      try {
        Thread.sleep(retardo);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}