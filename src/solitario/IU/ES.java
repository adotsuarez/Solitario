package solitario.IU;

import solitario.Core.Mesa;

import java.util.Objects;
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

    /** Devuelve un mensaje en caja principal
     * @param msg Mensaje a mostrar
     * @param input true: Mostrar la linea de entrada de texto
     *              false: No mostrar la linea de entrada de texto
     * @return String con caja con mensaje (linea de input opcional)
     */
    public static String boxMsg(String msg, boolean input) {
        clearScreen();

        StringBuilder sb = new StringBuilder();
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
        sb.append("       A       B       C       D        Stack\n")
                .append("   ┌-------┬-------┬-------┬-------┐  ┌-------┐\n")
                .append(" 1 |                               |  |       |\n")
                .append("   |                               ┤  ├-------┤\n")
                .append(" 2 |                               |  |       |\n")
                .append("   ├");

        // Append el mensaje dado
        sb.append(msgInLine.toString());

        // Termina la caja
        sb.append("┤  ├-------┤\n")
                .append(" 3 |                               |  |       |\n")
                .append("   ├                               ┤  ├-------┤\n")
                .append(" 4 |                               |  |       |\n")
                .append("   └-------┴-------┴-------┴-------┘  └-------┘\n");

        // En caso de querer linea de entrada
        if (input) {
            sb.append("-------------------------------------------------\n")
                    .append("Input > ");
        }
        return sb.toString();
    }

    /** Devuelve una caja completa dada una mesa
     * @param mesa Mesa completa, con sus valores
     * @return String con caja llena y linea de input
     */
    public static String box(Mesa mesa) {
        clearScreen();
        StringBuilder sb = new StringBuilder();

        sb.append("       A       B       C       D        Stack\n")
                .append("   ┌-------┬-------┬-------┬-------┐  ┌-------┐\n");

        for (int row = 1; row <= 4; row++) {
            sb.append(" ")
                    .append((row+1));

            for (int col = 1; col <= 4; col++) {
                sb.append(" | ")
                        .append(ES.carta(mesa,row,col));
            }

            sb.append(" |  | ")
                    .append(ES.carta(mesa,row))
                    .append(" |\n");

            if (row != 4) {
                sb.append("   ├-------┼-------┼-------┼-------┤  ├-------┤\n");
            } else {
                sb.append("   └-------┴-------┴-------┴-------┘  └-------┘\n");
            }
        }

        sb.append("-------------------------------------------------\n")
                .append("Input > ");

        return sb.toString();
    }

    /** Devuelve una caja completa dada una mesa con una carta seleccionada
     * @param mesa Mesa completa, con sus valores
     * @param opt Opcion seleccionada
     * @return String con caja llena y linea de input indicando la pila seleccionada
     */
    public static String box(Mesa mesa, String opt) {
        clearScreen();
        StringBuilder sb = new StringBuilder();

        sb.append("       A       B       C       D        Stack\n" +
                "   ┌-------┬-------┬-------┬-------┐  ┌-------┐\n");

        for (int row = 1; row <= 4; row++) {
            sb.append(" ")
                    .append((row+1));

            for (int col = 1; col <= 4; col++) {
                sb.append(" | ")
                        .append(ES.carta(mesa,row,col,opt));
            }

            sb.append(" |  | ")
                    .append(ES.carta(mesa,row,opt))
                    .append(" |\n");

            if (row != 4) {
                sb.append("   ├-------┼-------┼-------┼-------┤  ├-------┤\n");
            } else {
                sb.append("   └-------┴-------┴-------┴-------┘  └-------┘\n");
            }
        }

        sb.append("-------------------------------------------------\n")
                .append("\u001B[32m")
                .append(opt)
                .append("\u001B[0m")
                .append(" > ");

        return sb.toString();
    }


    /** Devuelve una carta formateada (la primera de la pila)
     * @param mesa Mesa en la que se encuentra la carta pedida y seleccionada
     * @param row Fila de la zona interior en la que se encuentra la carta pedida
     * @param col Columna de la zona interior en la que se encuentra la carta pedida
     * @return String con la carta pedida formateada
     */
    private static String carta(Mesa mesa, int row, int col) {
        // Code
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param mesa Mesa en la que se encuentra la carta pedida y seleccionada
     * @param row Fila de la zona interior en la que se encuentra la carta pedida
     * @param col Columna de la zona interior en la que se encuentra la carta pedida
     * @param opt Carta seleccionada
     * @return String con la carta pedida formateada
     */
    private static String carta(Mesa mesa, int row, int col, String opt) {
        // Code
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param mesa Mesa en la que se encuentra la carta pedida y seleccionada
     * @param stack Pila de la zona exterior en el que se encuentra la carta pedida
     * @return String con la carta pedida formateada
     */
    private static String carta(Mesa mesa, int stack) {
        // Code
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param mesa Mesa en la que se encuentra la carta pedida y seleccionada
     * @param stack Pila de la zona exterior en el que se encuentra la carta pedida
     * @param opt Carta seleccionada
     * @return String con la carta pedida formateada
     */
    private static String carta(Mesa mesa, int stack, String opt) {
        // Code
    }

    /** Limpia la pantalla añadiendo 20 líneas en blanco
     */
    public static void clearScreen() {
        for (int i = 0; i <= 20; i++) {
            System.out.print('\n');
        }
    }

    /** Verifica si una entrada es correcta
     * @param opt entrada facilitada
     * @return true: La entrada es correcta
     *         false: La entrada es incorrecta
     */
    public static boolean validOption(String opt) {
        // Code
    }

    /** Trasnforma una entrada al formato correcto
     * @param opt entrada facilitada
     * @return La entrada transformada
     */
    public static String transformOption(String opt) {
        opt = opt.toUpperCase();
        StringBuilder sb = new StringBuilder();

        if (opt.length() == 2) {                    // 2 caracteres
            if ((opt.charAt(0) == '1'
                    || opt.charAt(0) == '2'
                    || opt.charAt(0) == '3'
                    || opt.charAt(0) == '4')
                    && (opt.charAt(1) == 'A'
                    || opt.charAt(1) == 'B'
                    || opt.charAt(1) == 'C'
                    || opt.charAt(1) == 'D')) {     // Es una celda (1A)
                sb.append(opt.charAt(1));
                sb.append(opt.charAt(0));
            } else if ((opt.charAt(0) == 'A'
                    || opt.charAt(0) == 'B'
                    || opt.charAt(0) == 'C'
                    || opt.charAt(0) == 'D')
                    && (opt.charAt(1) == '1'
                    || opt.charAt(1) == '2'
                    || opt.charAt(1) == '3'
                    || opt.charAt(1) == '4')) {     // Es una celda (A1)
                sb.append(opt.charAt(0));
                sb.append(opt.charAt(1));
            } else {
                sb.append('*');                     // No es una celda
            }
        } else if (Objects.equals(opt, "HELP")
                || Objects.equals(opt, "EXIT")
                || Objects.equals(opt, "RESTART")
                || Objects.equals(opt, "STACK")
                || Objects.equals(opt, "CANCEL")) {   // Es una opción válida NO celda
            sb.append(opt);
        } else {                                    // No es ninguna de las anteriores
            sb.append('*');
        }

        return sb.toString();
    }
}
