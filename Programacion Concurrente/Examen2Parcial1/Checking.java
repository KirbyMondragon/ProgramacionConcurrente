package Examen2Parcial1;
class empleado implements Runnable {
  public int retardo;
  public int hora;
   String dia;
   String nombre;


  public empleado( int retardo,int hora,String dia, String nombre) {
    this.retardo = retardo;
    this.hora = hora;
    this.dia = dia;
    this.nombre = nombre;
  } 

  public void run() {
    if(hora >= 8){
        System.out.println("estas a tiempo " + nombre);
    }
    else
    {
        System.out.println("Llegaste tarde");
    }
      try {
        Thread.sleep(retardo);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    
  }
}