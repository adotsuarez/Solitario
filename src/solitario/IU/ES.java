package solitario.IU;

import solitario.Core.Jugador;

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
    public static final String ANSI_DEFAULT = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    /** Devuelve un mensaje de error
     * @param msg Motivo del error
     * @return Mensaje de error
     */
    public static String errorInput(String msg) {
        StringBuilder sb = new StringBuilder(ANSI_RED_BACKGROUND);
        sb.append(msg)
                .append(ANSI_DEFAULT)
                .append(ANSI_RED)
                .append(" Input > ")
                .append(ANSI_DEFAULT);
        return sb.toString();
    }

    /** Devuelve un mensaje de error con input personalizado
     * @param msg Motivo del error
     * @param opt Pila seleccionada previamente
     * @return Mensaje de error
     */
    public static String errorInput(String msg, String opt) {
        StringBuilder sb = new StringBuilder(ANSI_RED_BACKGROUND);
        sb.append(msg)
                .append(ANSI_DEFAULT)
                .append(ANSI_RED)
                .append(" ")
                .append(opt)
                .append(" > ")
                .append(ANSI_DEFAULT);
        return sb.toString();
    }

    /** Devuelve un mensaje en caja principal
     * @return String con el texto introducido por el usuario
     */
    public static String askForString() {
        Scanner dataInput = new Scanner(System.in);
        return dataInput.nextLine();
    }


    /** Devuelve un mensaje en caja principal
     * @param msg Mensaje a mostrar
     * @param input true: Mostrar la linea de entrada de texto
     *              / false: No mostrar la linea de entrada de texto
     * @return String con caja con mensaje (linea de input opcional)
     */
    public static String boxMsg(String msg, boolean input) {
        clearScreen();

        StringBuilder sb = new StringBuilder(ANSI_DEFAULT);
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

    /** Devuelve una caja completa dado un jugador
     * @param jugador Jugador actual
     * @return String con caja llena y linea de input
     */
    public static String box(Jugador jugador) {
        clearScreen();
        StringBuilder sb = new StringBuilder(ANSI_DEFAULT);

        sb.append("       A       B       C       D        Stack\n")
                .append("   ┌-------┬-------┬-------┬-------┐  ┌-------┐\n");

        for (int row = 0; row <= 3; row++) {
            sb.append(" ")
                    .append((row+1));

            for (int col = 0; col <= 3; col++) {
                sb.append(" | ")
                        .append(ES.carta(jugador,row,col));
            }

            sb.append(" |  | ")
                    .append(ES.carta(jugador,row))
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

    /** Devuelve una caja completa dada un jugador con carta seleccionada
     * @param jugador Jugador actual
     * @param opt Opcion seleccionada
     * @return String con caja llena y linea de input indicando la pila seleccionada
     */
    public static String box(Jugador jugador, String opt) {
        clearScreen();
        StringBuilder sb = new StringBuilder();

        sb.append("       A       B       C       D        Stack\n" +
                "   ┌-------┬-------┬-------┬-------┐  ┌-------┐\n");

        for (int row = 0; row <= 3; row++) {
            sb.append(" ")
                    .append((row+1));

            for (int col = 0; col <= 3; col++) {
                sb.append(" | ")
                        .append(ES.carta(jugador,row,col,opt));
            }

            sb.append(" |  | ")
                    .append(ES.carta(jugador,row,opt))
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
                .append(ANSI_DEFAULT)
                .append(" > ");

        return sb.toString();
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param jugador Jugador actual
     * @param row Fila de la zona interior en la que se encuentra la carta pedida
     * @param col Columna de la zona interior en la que se encuentra la carta pedida
     * @return String con la carta pedida formateada
     */
    private static String carta(Jugador jugador, int row, int col) {
        StringBuilder sb = new StringBuilder(ANSI_DEFAULT);

        if (!jugador.empty(row,col)) {      // Existe alguna carta
            sb.append(jugador.viewCarta(row, col).toString()).append(ANSI_DEFAULT);
        } else {                              // No hay ninguna carta
            sb.append("     ");
        }

        return sb.toString();
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param jugador Jugador actual
     * @param row Fila de la zona interior en la que se encuentra la carta pedida
     * @param col Columna de la zona interior en la que se encuentra la carta pedida
     * @param opt Carta seleccionada
     * @return String con la carta pedida formateada
     */
    private static String carta(Jugador jugador, int row, int col, String opt) {
        StringBuilder sb = new StringBuilder();

        int[] selected = transformOption(opt);

        if (!jugador.empty(row,col)) {      // Existe alguna carta
            if (selected[0] == row && selected[1] == col) {
                sb.append(ANSI_GREEN_BACKGROUND);
            } else if (stackable(jugador.viewCarta(selected[0],selected[1]),
                    jugador.viewCarta(row,col),
                    false)) {
                sb.append(ANSI_BLUE);
            }

            sb.append(jugador.viewCarta(row,col).toString()).append(ANSI_DEFAULT);
        } else {                             // No hay ninguna carta
            sb.append("     ");
        }

        return sb.toString();
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param jugador Jugador actual
     * @param stack Pila de la zona exterior en el que se encuentra la carta pedida
     * @return String con la carta pedida formateada
     */
    private static String carta(Jugador jugador, int stack) {
        StringBuilder sb = new StringBuilder(ANSI_DEFAULT);

        if (!jugador.empty(stack)) {       // Existe alguna carta
            sb.append(jugador.viewCarta(stack).toString()).append(ANSI_DEFAULT);
        } else {                        // No hay ninguna carta
            sb.append("     ");
        }

        return sb.toString();
    }

    /** Devuelve una carta formateada (la primera de la pila)
     * @param jugador Jugador actual
     * @param stack Pila de la zona exterior en el que se encuentra la carta pedida
     * @param opt Carta seleccionada
     * @return String con la carta pedida formateada
     */
    private static String carta(Jugador jugador, int stack, String opt) {
        StringBuilder sb = new StringBuilder();

        int[] selected = transformOption(opt);

        if (!jugador.empty(stack)) {      // Existe alguna carta
            if(stackable(jugador.viewCarta(selected[0],selected[1]),
                    jugador.viewCarta(stack),
                    true)) {
                sb.append(ANSI_BLUE);
            }
            sb.append(jugador.viewCarta(stack).toString()).append(ANSI_DEFAULT);
        } else {                            // No hay ninguna carta
            int i = 0;

            while (i<stack && !jugador.empty(i)) {
                i++;
            }

            if (i == stack      // Pila detenida tras recorrido == Pila pedida
                    && jugador.viewCarta(selected[0],selected[1]).getNumero() == 0) {   // opt es un as
                sb.append(ANSI_BLUE)
                        .append(" ### ")
                        .append(ANSI_DEFAULT);
            } else {
                sb.append("     ");
            }
        }

        return sb.toString();
    }

    /** Limpia la pantalla anadiendo 20 lineas en blanco
     */
    private static void clearScreen() {
        for (int i = 0; i <= 20; i++) {
            System.out.print('\n');
        }
    }

    /** Trasnforma una opcion/seleccion en fila/columna
     * @param opt seleccion (celda) facilitada en formato transformInput
     * @return fila [0] y columna [1] como array de dos enteros
     */
    public static int[] transformOption(String opt) {
        int[] toret = new int[2];

        toret[0] = Character.getNumericValue(opt.charAt(1)) - 1;   // ROW (1-4) -> (0-3)

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
                return gameMode != Solitario.Mode.STOPPED;
            } else if (Objects.equals(opt, "STACK")) {
                return gameMode == Solitario.Mode.CARDSELECTED;
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
        opt = opt.toUpperCase().trim();
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
