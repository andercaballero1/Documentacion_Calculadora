package principal;
/**
 * 
 * @author Ander Caballero
 *
 */

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import menu.Menu;
import operaciones.Operaciones;

public class Calculadora{
	private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());
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
        
        Handler fileHandler = null;
        Handler consoleHandler = new ConsoleHandler();
        
        try{
        	fileHandler  = new FileHandler("./logs/operaciones.log");;	
        }catch(IOException exception){
        	LOGGER.log(Level.SEVERE, "OcurriÃ³ un error en FileHandler.", exception);
        }
        LogManager.getLogManager().reset();
        
        LOGGER.addHandler(fileHandler);
        LOGGER.addHandler(consoleHandler);
        
        consoleHandler.setLevel(Level.WARNING);
        fileHandler.setLevel(Level.FINE);
        LOGGER.setLevel(Level.FINE);
        
        
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
	            LOGGER.log(Level.FINE, "Operacion: " + operacion + " Operando 1: " + operandos[0] + " Operando 2:" + operandos[1] + " Resultado: " + resultado);
	        } catch (ArithmeticException e) {
	        	System.out.println ("Operacion aritmetica no valida " + e.getMessage());
	        	LOGGER.log(Level.WARNING, "Division entre cero.");
	        }  
        }   while (menu.repetir());
    }
}