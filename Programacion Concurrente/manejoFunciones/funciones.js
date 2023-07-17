//Definir funciones en javascript
/*  Una función es un bloque de código que realiza alguna operación.
 Una función puede definir opcionalmente parámetros de entrada que permiten
  a los llamadores pasar argumentos a la función. 
  Una función también puede devolver un valor como salida.

  https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Functions
*/



//Como crear funciones
/*Una definición de función (también denominada declaración de función o expresión de función) consta de la palabra clave function, seguida de:

    * El nombre de la función.
    * Una lista de parámetros de la función, entre paréntesis y separados por comas.
    * Las declaraciones de JavaScript que definen la función, encerradas entre llaves, { ... }.
  */

//Ejemplos




//4.Funciones con parámetros y valores de retorno
function frase(){
    console.log("Este es un ejemplo de una funcion que no requiere ningun parametro para ser llamada");
}

function suma(numero1,numero2){
   var resultado = numero1+numero2;
   console.log(resultado);
   return resultado;
}


//como invocar funciones en javascript de diferente manera



 function saludoUsuario(){
    console.log("Hola mi nombre es el fresco Kirby y este un ejemplo de uso de funciones");
    
 }
// Función normal
function calcularBMINormal(peso, altura) {
    var alturaMetros = altura / 100;
    var bmi = peso / (alturaMetros * alturaMetros);
    return bmi.toFixed(2);
  }
  
  console.log(calcularBMINormal(70, 170)); // Resultado: 24.22
  
  
  // Función de flecha
  const calcularBMIFlecha = (peso, altura) => {
    var alturaMetros = altura / 100;
    var bmi = peso / (alturaMetros * alturaMetros);
    return bmi.toFixed(2);
  }
  
  console.log(calcularBMIFlecha(70, 170)); // Resultado: 24.22
  
  
  // Función anónima
  const calcularBMIAnonima = function(peso, altura) {
    var alturaMetros = altura / 100;
    var bmi = peso / (alturaMetros * alturaMetros);
    return bmi.toFixed(2);
  }
  
  console.log(calcularBMIAnonima(70, 170)); // Resultado: 24.22
  
  
  // Función de retorno
  function obtenerFuncionBMI() {
    return function(peso, altura) {
      var alturaMetros = altura / 100;
      var bmi = peso / (alturaMetros * alturaMetros);
      return bmi.toFixed(2);
    }
  }
  
  const calcularBMIRetorno = obtenerFuncionBMI();
  console.log(calcularBMIRetorno(70, 170)); // Resultado: 24.22
  
