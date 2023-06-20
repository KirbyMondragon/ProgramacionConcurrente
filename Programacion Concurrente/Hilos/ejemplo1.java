package Hilos;
public class ejemplo1 implements Runnable {
  // cuando se implementa la interfaz Runnable, se debe implementar el método run
  private String nombre;

  public String getNombre() {
    return nombre;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public ejemplo1(String nombre) {
    this.nombre = nombre;
  }

  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Tarea " + nombre);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Tarea 2 " + nombre);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
  }
}
