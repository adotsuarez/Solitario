/*
 * Representa el juego del solitario, con sus reglas.
 * Se recomienda una implementación modular.
 */
package solitario.IU;

import solitario.Core.Carta;
import solitario.Core.Jugador;
import solitario.Core.Mesa;

import static solitario.IU.ES.*;

/**
 *
 * @author
 * - Iago Sanchez Garcia, '@LeeroyMerlin'
 * - Manuel Alejandro Silva Cheda, '@AlejandroCheda'
 * - Cristina Lavadores Pedrosa, '@TinaP5'
 * - Agustin Suarez Martinez, '@adotsuarez' [PM]
 *
 */
public class Solitario {

    /** Enumerado con los posibles modos
     */
    public enum Mode {
        RESTING,
        CARDSELECTED,
        STOPPED,
        RESTART
    }

    /** Modo de juego
     */
    public static Mode gameMode;

    /** Pila seleccionada previamente
     */
    public static String prev = "";

    /** Opcion/Comando/Pila introducida
     */
    public static String opt = "";

    /** Mostrando pantalla de informacion
     */
    public static boolean showingInfo;

    /** Programa principal
     */
    public static void inicioPartida(){
        do {            // Inicio

            gameMode = Mode.RESTING;
            Jugador jugador = new Jugador(pantallaInicio());

            System.out.print(box(jugador));
            showingInfo = false;
            int[] prevValues;
            int[] optValues;

            do {        // Programa ejecutandose

                do {    // Opcion correcta
                    opt = transformInput(askForString());

                    if (validInput(opt)) {
                        switch (opt) {
                            case "CANCEL":
                                if (showingInfo && gameMode == Mode.CARDSELECTED) {
                                    System.out.print(box(jugador, prev));
                                } else {
                                    gameMode = Mode.RESTING;
                                    System.out.print(box(jugador));
                                }
                                showingInfo = false;
                                break;

                            case "END":
                                gameMode = Mode.STOPPED;
                                break;

                            case "RESTART":
                                gameMode = Mode.RESTART;
                                break;

                            case "INFO":
                                showingInfo = true;
                                System.out.print(boxMsg("ℹ: http://cutt.ly/solitario",true));
                                break;

                            case "STACK":
                                if (gameMode == Mode.CARDSELECTED) {
                                    prevValues = transformOption(prev);

                                    int stack = 0;
                                    while(!jugador.empty(stack)
                                            && stack < 4
                                            && jugador.viewCarta(prevValues[0],prevValues[1]).getPalo()
                                            != jugador.viewCarta(stack).getPalo()) {
                                        stack++;
                                    }

                                    if (jugador.empty(stack)) {     // A colocar en destino vacio
                                        if (jugador.viewCarta
                                                (prevValues[0],prevValues[1])
                                                .getNumero() == 0) {      // Es un as
                                            jugador.move(prevValues, stack);
                                            gameMode = Mode.RESTING;
                                            System.out.print(box(jugador));
                                        }

                                    } else if (stackable(jugador.viewCarta
                                                    (prevValues[0],prevValues[1]),
                                            jugador.viewCarta(stack),
                                            true)) {             // Verificamos si es apilable

                                        jugador.move(prevValues,stack);
                                        gameMode = Mode.RESTING;
                                        System.out.print(box(jugador));
                                    }

                                }
                                break;

                            default:
                                optValues = transformOption(opt);

                                // Hay una carta en la pila introducida?
                                if (!jugador.empty(optValues[0],optValues[1])) {

                                    // Hay ya una carta seleccionada?
                                    if(gameMode == Mode.CARDSELECTED) {

                                        prevValues = transformOption(prev);

                                        // Es posible apilar la opt sobre la prev?
                                        if (stackable(jugador.viewCarta(prevValues[0],prevValues[1]),
                                                jugador.viewCarta(optValues[0],optValues[1]),
                                                false)) {

                                            jugador.move(prevValues,optValues);
                                            gameMode = Mode.RESTING;
                                            System.out.print(box(jugador));

                                        } else {    // No es posible apilar la carta nueva sobre prev
                                            System.out.print(box(jugador,prev));
                                        }
                                    } else {    // No hay una carta seleccionada previamente

                                        gameMode = Mode.CARDSELECTED;
                                        prev = opt;

                                        System.out.print(box(jugador,opt));
                                    }
                                } else {
                                    // Hay ya una carta seleccionada?
                                    if(gameMode == Mode.CARDSELECTED) {
                                        System.out.print(ES.errorInput("¡Pila sin cartas!",prev));
                                    } else {    // No hay una carta seleccionada previamente
                                        System.out.print(ES.errorInput("¡Pila sin cartas!"));
                                    }
                                }
                        }
                    } else {
                        System.out.print(ES.errorInput("¡Entrada incorrecta!"));
                    }

                    if (finished(jugador)) {
                        System.out.print(ANSI_YELLOW
                                + "Game over! ");
                        if (won(jugador)) {
                            System.out.print("Has ganado. ¡Felicidades!");
                        } else {
                            System.out.print("No quedan movimientos.");
                        }
                        System.out.println(ANSI_DEFAULT);
                        gameMode = Mode.STOPPED;
                    }

                } while (!validInput(opt));

            } while (gameMode != Mode.STOPPED && gameMode != Mode.RESTART);

        } while (gameMode != Mode.STOPPED);
    }

    /** Muestra pantalla inicio
     * @return String con el nombre del jugador introducido
     */
    private static String pantallaInicio() {
        System.out.print(boxMsg("Introduce tu nombre",true));
        return askForString();
    }

    /** Verifica si una carta puede ser colocada encima de otra
     * @param toStack Carta a apilar
     * @param stackOn Ultima carta de la pila en la que se quiere colocar
     * @param destinoExterior true: El destino esta en la zona exterior
     *                     / false: El destino esta en la zona interior
     * @return true: Se puede colocar encima
     *         / false: No se puede colocar encima
     */
    public static boolean stackable(Carta toStack, Carta stackOn, boolean destinoExterior) {
        boolean toret = false;
        if (destinoExterior) {
            if (stackOn.getPalo() == toStack.getPalo()
                    && stackOn.getNumero() + 1 == toStack.getNumero()) {
                toret = true;
            }
        } else {
            if (stackOn.getPalo() == toStack.getPalo()
                    && stackOn.getNumero() == toStack.getNumero() + 1) {
                toret = true;
            }
        }
        return toret;
    }

    /** Verifica si el juego ya ha terminado
     * @param jugador jugador con la mesa a analizar
     * @return true: No se puede colocar continuar
     *         / false: Se puede continuar
     */
    private static boolean finished(Jugador jugador) {
        int rowComp;
        int colComp;
        int stack;

        for (int rowSelected = 0; rowSelected < 4; rowSelected++) {
            for (int colSelected = 0; colSelected < 4; colSelected++) {

                // Zona exterior
                if (!jugador.empty(rowSelected,colSelected)) {

                    stack = 0;
                    while(!jugador.empty(stack)
                            && stack < 4
                            && jugador.viewCarta(rowSelected,colSelected).getPalo()
                            != jugador.viewCarta(stack).getPalo()) {
                        stack++;
                    }

                    if (jugador.empty(stack)) {     // A colocar en destino vacio
                        if (jugador.viewCarta
                                (rowSelected,colSelected)
                                .getNumero() == 0) {      // Es un as
                            return false;
                        }

                    } else if (stackable(jugador.viewCarta
                                    (rowSelected,colSelected),
                            jugador.viewCarta(stack),
                            true)) {             // Verificamos si es apilable

                        return false;
                    }
                }

                // Zona interior
                rowComp = rowSelected;
                colComp = colSelected;

                while (rowComp < 4 && colComp < 4) {
                    if (!jugador.empty(rowSelected,colSelected)
                            && !jugador.empty(rowComp,colComp)) {       // Hay cartas en ambas pilas

                        if (stackable(jugador.viewCarta(rowSelected,colSelected),
                                jugador.viewCarta(rowComp,colComp),
                                false)                                  // Stack Selected en Comp

                                || stackable(jugador.viewCarta(rowComp,colComp),
                                jugador.viewCarta(rowSelected,colSelected),
                                false)) {                               // Stack Comp en Selected

                            return false;
                        }

                    }

                    if (colComp == 3) {
                        rowComp++;
                        colComp = 0;
                    } else {
                        colComp++;
                    }
                }
            }
        }

        return true;
    }

    /** Verifica si el jugador ha ganado o perdido
     * - (Necesaria verificacion previa mediante finished)
     * @param jugador jugador con la mesa a analizar
     * @return true: El jugador ha ganado
     *         / false: El jugador ha perdido
     */
    private static boolean won(Jugador jugador) {
        int stack = 0;
        while (stack < 4 && !jugador.empty(stack) && jugador.viewCarta(stack).getNumero() == 9) {
            stack++;
        }
        return stack == 4;
    }
}
