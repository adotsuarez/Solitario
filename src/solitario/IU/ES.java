
package solitario.IU;

import java.util.Scanner;

/**
 *
 * @author AEDI
 */
public class ES
{
    public static Scanner leer = new Scanner(System.in);
    
    public static String pideCadena(String mensaje)
    {
         // Poner el mensaje
            System.out.print(mensaje);
               
             // Pedir
            return leer.nextLine();
               
    }
    
        
    public static int pideNumero(String mensaje)
    {
        
            System.out.print(mensaje);

            // Pedir
            return Integer.parseInt(leer.nextLine());
       
    }
}
