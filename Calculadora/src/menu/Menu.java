package menu;
/**
 * 
 * @author Ander Caballero
 *
 */

import java.util.Scanner;
public class Menu {
    private static Scanner teclado = new Scanner(System.in);
    
    
    /**
     * Pide dos numeros de tipo entero y los añade al array
     * @return devulve un Array con los numeros introducidos
     */
    public int[] pedirNumeros(){
        int[] ret = new int[2];
        System.out.print ("Operando 1: ");
        ret [0] = teclado.nextInt();
        System.out.print ("Operando 2: ");
        ret [1] = teclado.nextInt();
        return ret;
    }
    
    
    /**
     * Pide un String y si el String no coincide con ninguno de los simbolos vuelve a pedirte el String hasta que coincida con algun simbolo.
     * @return devuelve un String con el simbolo introducido
     */
    public String menuOpciones() {
        String ret = "";
        do {
            System.out.print ("Operaciones [+, -, *, /, %]: ");
            ret = teclado.next();
        } while (!((ret.equalsIgnoreCase("+")) || (ret.equalsIgnoreCase("-")) ||
                (ret.equalsIgnoreCase("*")) || (ret.equalsIgnoreCase("/")) ||
                (ret.equalsIgnoreCase("%"))
                ));
                return ret;
    }
    
    
    /**
     * Pregunta si el usuario quiere continuar. Si el usuario mete algun valor que no es "n" o "s" el programa vuelve a pedir una respuesta
     * Si el usuario desea continuar el valor del boolean se volvera true y si el usuario no quiere continuar el boolean continuara con valor false
     * @return devuelve un boolean con el valor true o false dependiendo de la respueta del usuario
     */
    public boolean repetir(){
        boolean ret = false;
        String respuesta;
        do {
            System.out.print ("¿Desea continuar trabajando con la calculadora? [s / n]");
            respuesta = teclado.next();
        } while (!((respuesta.equalsIgnoreCase("s")) || (respuesta.equalsIgnoreCase("n"))
                    ));
                    
        if (respuesta.equalsIgnoreCase("s")){
            ret = true;
        }
        return ret;
    }
}