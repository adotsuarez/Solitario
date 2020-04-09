package solitario.IU;

import solitario.Core.Mesa;

import java.util.Objects;
import java.util.Scanner;

import static solitario.IU.Solitario.*;

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

    // Colours
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static Scanner dataInput = new Scanner(System.in);

    /** Devuelve un mensaje en caja principal
     * @return String con el texto introducido por el usuario
     */
    public static String askForString() {
        return dataInput.nextLine();
    }

    /** Devuelve un mensaje en caja principal
     * @param msg Mensaje a mostrar
     * @return String con el texto introducido por el usuario
     */
    public static String askForString(String msg) {
        // Poner el mensaje
        System.out.print(msg);
        // Pedir
        return dataInput.nextLine();
    }

    /** Devuelve un mensaje en caja principal
     * @return Entero introducido por el usuario
     */
    public static int askForInt() {
        return Integer.parseInt(dataInput.nextLine());
    }

    /** Devuelve un mensaje en caja principal
     * @param msg Mensaje a mostrar
     * @return Entero introducido por el usuario
     */
    public static int askForInt(String msg) {
        // Poner el mensaje
        System.out.print(msg);
        // Pedir
        return Integer.parseInt(dataInput.nextLine());
    }

    /** Devuelve un mensaje en caja principal
     * @param msg Mensaje a mostrar
     * @param input true: Mostrar la linea de entrada de texto
     *              / false: No mostrar la linea de entrada de texto
     * @return String con caja con mensaje (linea de input opcional)
     */
    public static String boxMsg(String msg, boolean input) {
        clearScreen();

        StringBuilder sb = new StringBuilder(ANSI_RESET);
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
        StringBuilder sb = new StringBuilder(ANSI_RESET);

        sb.append("       A       B       C       D        Stack\n")
                .append("   ┌-------┬-------┬-------┬-------┐  ┌-------┐\n");

        for (int row = 0; row <= 3; row++) {
            sb.append(" ")
                    .append((row+1));

            for (int col = 0; col <= 3; col++) {
                sb.append(" | ")
                        .append(ES.carta(mesa,row,col));
            }

            sb.append(" |  | ")
                    .append(ES.carta(mesa,row))
                    .append(" |\n");

            if (row != 3) {
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

        for (int row = 0; row <= 3; row++) {
            sb.append(" ")
                    .append((row+1));

            for (int col = 0; col <= 3; col++) {
                sb.append(" | ")
                        .append(ES.carta(mesa,row,col,opt));
            }

            sb.append(" |  | ")
                    .append(ES.carta(mesa,row,opt))
                    .append(" |\n");

            if (row != 3) {
                sb.append("   ├-------┼-------┼-------┼-------┤  ├-------┤\n");
            } else {
                sb.append("   └-------┴-------┴-------┴-------┘  └-------┘\n");
            }
        }

        sb.append("-------------------------------------------------\n")
                .append(ANSI_GREEN)
                .append(opt)
                .append(ANSI_RESET)
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
        StringBuilder sb = new StringBuilder(ANSI_RESET);

        if (mesa.theresCarta(row,col)) {      // Existe alguna carta
            sb.append(mesa.getCarta(row, col).toString()).append(ANSI_RESET);
        } else {                              // No hay ninguna carta
            sb.append("   ");
        }

        return sb.toString();
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param mesa Mesa en la que se encuentra la carta pedida y seleccionada
     * @param row Fila de la zona interior en la que se encuentra la carta pedida
     * @param col Columna de la zona interior en la que se encuentra la carta pedida
     * @param opt Carta seleccionada
     * @return String con la carta pedida formateada
     */
    private static String carta(Mesa mesa, int row, int col, String opt) {
        StringBuilder sb = new StringBuilder();

        if (mesa.theresCarta(row,col)) {      // Existe alguna carta
            if (stackable(mesa.getCarta(selectedRow,selectedCol),
                    mesa.getCarta(row,col),
                    false)) {
                sb.append(ANSI_BLUE);
            }

            sb.append(mesa.getCarta(row,col).toString()).append(ANSI_RESET);
        } else {                             // No hay ninguna carta
            sb.append("   ");
        }

        return sb.toString();
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param mesa Mesa en la que se encuentra la carta pedida y seleccionada
     * @param stack Pila de la zona exterior en el que se encuentra la carta pedida
     * @return String con la carta pedida formateada
     */
    private static String carta(Mesa mesa, int stack) {
        StringBuilder sb = new StringBuilder(ANSI_RESET);

        if (mesa.theresCarta(stack)) {      // Existe alguna carta
            sb.append(mesa.getCarta(stack).toString()).append(ANSI_RESET);
        } else {                            // No hay ninguna carta
            sb.append("   ");
        }

        return sb.toString();
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param mesa Mesa en la que se encuentra la carta pedida y seleccionada
     * @param stack Pila de la zona exterior en el que se encuentra la carta pedida
     * @param opt Carta seleccionada
     * @return String con la carta pedida formateada
     */
    private static String carta(Mesa mesa, int stack, String opt) {
        StringBuilder sb = new StringBuilder();

        if (mesa.theresCarta(stack)) {      // Existe alguna carta
            if(stackable(mesa.getCarta(selectedRow,selectedCol),
                    mesa.getCarta(stack),
                    true)) {
                sb.append(ANSI_BLUE);
            }
            sb.append(mesa.getCarta(stack).toString()).append(ANSI_RESET);
        } else {                            // No hay ninguna carta
            int i = 0;
            while (i<stack && mesa.theresCarta(i)) {
                i++;
            }
            if (i == stack) {
                sb.append(ANSI_BLUE)
                        .append("###")
                        .append(ANSI_RESET);
            } else {
                sb.append("   ");
            }
        }

        return sb.toString();
    }

    /** Limpia la pantalla anadiendo 20 lineas en blanco
     */
    public static void clearScreen() {
        for (int i = 0; i <= 20; i++) {
            System.out.print('\n');
        }
    }

    /** Trasnforma una opcion/seleccion en fila/columna
     * @param opt seleccion (celda) facilitada en formato transformInput
     * @return fila [0] y columna [1] como vector de dos enteros
     */
    public static int[] transformOption(String opt) {
        int[] toret = new int[2];

        toret[0] = opt.charAt(1) - 1;   // ROW (1-4) -> (0-3)

        switch (opt.charAt(0)) {        // COL (A-D) -> (0-3)
            case 'A':   toret[1] = 0;
                        break;
            case 'B':   toret[1] = 1;
                        break;
            case 'C':   toret[1] = 2;
                        break;
            case 'D':   toret[1] = 3;
                        break;
        }

        return toret;
    }

    /** Verifica si una entrada es correcta
     * @param opt entrada facilitada
     * @return true: La entrada es correcta
     *         / false: La entrada es incorrecta
     */
    public static boolean validInput(String opt) {
        if (!Objects.equals(opt, "*")) {
            if (opt.length() == 2) {
                return gameOn;
            } else if (Objects.equals(opt, "STACK")) {
                return gameOn && gameMode == Solitario.Mode.CARDSELECTED;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /** Trasnforma una entrada al formato correcto
     * @param opt entrada facilitada
     * @return La entrada transformada
     */
    public static String transformInput(String opt) {
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
        } else if (Objects.equals(opt, "STACK")
                || Objects.equals(opt, "CANCEL")
                || Objects.equals(opt, "END")
                || Objects.equals(opt, "RESTART")
                || Objects.equals(opt, "INFO")) {   // Es una opción válida NO celda
            sb.append(opt);
        } else {                                    // No es ninguna de las anteriores
            sb.append('*');
        }

        return sb.toString();
    }
}
