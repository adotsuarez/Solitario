package solitario.IU;

import java.util.Scanner;

/**
 *
 * @author
 * - Iago Sanchez Garcia, '@LeeroyMerlin'
 * - Manuel Alejandro Silva Cheda, '@AlejandroCheda'
 * - Cristina Lavadores Pedrosa, '@TinaP5'
 * - Agustin Suarez Martinez, '@adotsuarez' [PM]
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

    /** Muestra mensaje en caja principal
     * @param msg Mensaje a mostrar
     * @param input true: Mostrar la linea de entrada de texto
     *              false: No mostrar la linea de entrada de texto
     */
    public static String box(String msg, boolean input) {
        clearScreen();

        StringBuilder toret = new StringBuilder();
        StringBuilder msgInLine = new StringBuilder();

        // Mensaje ajustado para la caja
        if (msg.length() <= 31) {               // Verificacion de si no es muy largo
            for (int i = 0; i < ((31 - msg.length())/2); i++) {     // Ajuste por izda.
                msgInLine.append(' ');
            }
            if (msg.length() % 2 == 0) {        // Si el mensaje tiene un num par de caracteres
                msgInLine.append(' ');
            }
            msgInLine.append(msg);              // Append el mensaje dado completo
            for (int i = 0; i < ((31 - msg.length())/2); i++) {     // Ajuste por dcha.
                msgInLine.append(' ');
            }
        } else {                                // En caso de que sea muy largo
            msgInLine.append(msg,0,31);               // Corta el mensaje
        }

        // Empieza la caja
        toret.append("       A       B       C       D        Stack\n" +
                "   ┌-------┬-------┬-------┬-------┐  ┌-------┐\n" +
                " 1 |                               |  |       |\n" +
                "   |                               ┤  ├-------┤\n" +
                " 2 |                               |  |       |\n" +
                "   ├");

        // Append el mensaje dado
        toret.append(msgInLine.toString());

        // Termina la caja
        toret.append("┤  ├-------┤\n" +
                " 3 |                               |  |       |\n" +
                "   ├                               ┤  ├-------┤\n" +
                " 4 |                               |  |       |\n" +
                "   └-------┴-------┴-------┴-------┘  └-------┘\n");

        // En caso de querer linea de entrada
        if (input) {
            toret.append("-------------------------------------------------\n" +
                    "Input > ");
        }
        return toret.toString();
    }

    /** Limpia la pantalla añadiendo 20 líneas en blanco
     */
    public static void clearScreen() {
        for (int i = 0; i <= 20; i++) {
            System.out.print('\n');
        }
    }
}
