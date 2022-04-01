package principal;
/**
 * 
 * @author Ander Caballero
 *
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import logs.FiltroLogSoloCero;
import logs.FormatoHTML2;
import menu.Menu;
import operaciones.Operaciones;

public class Calculadora{
	private static final LogManager logManager = LogManager.getLogManager();
	private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());
	
	static{
		 try {
			 logManager.readConfiguration(new FileInputStream("./logs/configLog.properties"));
		 } catch (IOException exception) {
			 LOGGER.log(Level.SEVERE, "Error al cargar la configuración",exception);
		 }
	 }
	
    public static void main(String[] args) {   		
    	configurarLog(); 
    	
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
	            LOGGER.log(Level.FINE, "Operacion: " + operacion + " |Operando1: " + operandos[0] + " |Operando2: " + operandos[1] + " |Resultado: " + resultado);
	        } catch (ArithmeticException e) {
	        	System.out.println ("Operacion aritmetica no valida " + e.getMessage());
	        	LOGGER.log(Level.WARNING, "Division entre cero.");
	        }  
        }   while (menu.repetir());
    }
    
   public static void configurarLog() { 
    		
         Handler fileHandlerr = null;
         Handler consoleHandler = new ConsoleHandler();
         
         //Asignar handlers al objeto LOGGER
         LOGGER.addHandler(consoleHandler);
         
         try{
        	 fileHandlerr  = new FileHandler("./logs/resultadosNulos.html");	
         }catch(IOException exception){
         	LOGGER.log(Level.SEVERE, "OcurriÃ³ un error en FileHandler.", exception);
         }
         // LogManager.getLogManager().reset();
         
         
         // Formato
         fileHandlerr.setFormatter(new FormatoHTML2());
         
         
         //Asignar handlers al objeto LOGGER
         LOGGER.addHandler(fileHandlerr);
         
         //Establecer niveles a handlers y LOGGER
         consoleHandler.setLevel(Level.WARNING);
         fileHandlerr.setLevel(Level.FINE);
         LOGGER.setLevel(Level.FINE);
         
         // Añadir filtro para Handler
         fileHandlerr.setFilter(new FiltroLogSoloCero());
    } 
    
}