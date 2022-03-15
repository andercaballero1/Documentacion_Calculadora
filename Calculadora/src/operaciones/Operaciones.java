package operaciones;
/**
 * 
 * @author Ander Caballero
 *
 */

public class Operaciones{

	/**
	 * Se introducen dos valores y se declara un entero que almacena la suma de los dos valores 
	 * @param valor1 primer valor introducido
	 * @param valor2 segundo valor introducido
	 * @return devuelve la suma de los dos valores en un entero
	 */
	public int sumar (int valor1, int valor2){
        int numero;
        numero = valor1 + valor2;
        return numero;
    }
    
	
	/**
	 * Se introducen dos valores y se declara un entero que almacena la resta de los dos valores
	 * @param valor1 primer valor introducido
	 * @param valor2 segundo valor introducido
	 * @return devuelve la resta de los dos valores en un entero
	 */
    public int restar (int valor1, int valor2){
        int numero;
        numero = valor1 - valor2;
        return numero;
    }
    
    
    /**
     *  Se introducen dos valores y se declara un entero que almacena la multiplacion de los dos valores
     * @param valor1 primer valor introducido
     * @param valor2 segundo valor introducido
     * @return devuelve la multiplacion de los valores en un entero
     */
    public int multiplicar (int valor1, int valor2){
        int numero;
        numero = valor1 * valor2;
        return numero;
    }
    
    /**
     * Se introducen dos valores y se declara un entero que almacena la division de los dos valores
     * @param valor1 primer valor introducido
     * @param valor2 segundo valor introducido
     * @return devuelve la division de los valores en un entero
     * @throws ArithmeticException Contemplamos la division entre cero y mostramos un mensaje
     */
    public int dividir (int valor1, int valor2) throws ArithmeticException{
        int numero;
        numero = valor1 / valor2;
        return numero;
    }
    
    /**
     * Se introducen dos valores y se declara un entero que almacena el resto de la division de los dos valores
     * @param valor1 primer valor introducido
     * @param valor2 segundo valor introducido
     * @return devuelve el resto de la division de los dos valores en un entero
     */
    public int resto (int valor1, int valor2){
        int numero;
        numero = valor1 % valor2;
        return numero;
    }
}