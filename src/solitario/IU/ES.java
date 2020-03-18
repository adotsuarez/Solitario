package solitario.IU;

import java.util.Scanner;

/**
 *
 * @author
 * Iago Sánchez García, '@LeeroyMerlin'
 * Manuel Alejandro Silva Cheda, '@AlejandroCheda'
 * Agustín Suárez Martínez, '@adotsuarez' [PM]
 *
 * Project for [AED1] - 1st grade CSE - ESEI.
 * https://github.com/adotsuarez/Solitario
 *
 */
public class ES {
    public static Scanner leer = new Scanner(System.in);
    
    public static String pideCadena(String mensaje) {

        // Poner el mensaje
        System.out.print(mensaje);

        // Pedir
        return leer.nextLine();

    }

    public static int pideNumero(String mensaje) {

        // Poner el mensaje
        System.out.print(mensaje);

        // Pedir
        return Integer.parseInt(leer.nextLine());

    }
}
