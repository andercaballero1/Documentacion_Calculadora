package principal;
/**
 * 
 * @author Ander Caballero
 *
 */

import menu.Menu;
import operaciones.Operaciones;

public class Calculadora{
    public static void main(String[] args) {
    	/**
    	 * Esta parte seria el main de nuestro programa. Aqui sera donde llamaremos a las otras clases 'operaciones' y 'menu'
    	 * En esta clase tendremos la excepcion de ArithmeticException 
    	 */
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int [2];
        
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
        
        do{
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();
            
	        try {
	            if (operacion.equalsIgnoreCase("+")){
	                resultado = operaciones.sumar(operandos[0], operandos[1]);
	                System.out.println ("Resultado: " + resultado);
	            } else if (operacion.equalsIgnoreCase("-")){
	                resultado = operaciones.restar(operandos[0], operandos[1]);
	                System.out.println ("Resultado: " + resultado);
	            } else if (operacion.equalsIgnoreCase("*")){
	                resultado = operaciones.multiplicar(operandos[0], operandos[1]);
	                System.out.println ("Resultado: " + resultado);
	            } else if (operacion.equalsIgnoreCase("/")){
	                resultado = operaciones.dividir(operandos[0], operandos[1]);
	                System.out.println ("Resultado: " + resultado);
	            } else if (operacion.equalsIgnoreCase("%")){
	                resultado = operaciones.resto(operandos[0], operandos[1]);
	                System.out.println ("Resultado: " + resultado);
	            } else {
	                System.out.println ("Operación no válida");
	            }
	        } catch (ArithmeticException e) {
	        	System.out.println ("Operacion aritmetica no valida " + e.getMessage());
	        }  
        }   while (menu.repetir());
    }
}