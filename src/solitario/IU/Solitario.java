/*
 * Representa el juego del solitario, con sus reglas.
 * Se recomienda una implementación modular.
 */
package solitario.IU;

import solitario.Core.Carta;
import solitario.Core.Jugador;
import solitario.Core.Mesa;

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
public class Solitario {

    public static enum Mode {
        RESTING,
        INFOSCREEN,
        CARDSELECTED
    }

    /** Juego ejecutándose
     */
    public static boolean gameOn;
    public static Mode gameMode;

    /** Programa principal
     */
    public static void inicioPartida(){
        boolean repeatGame;

        // REPL
        do {
            repeatGame = false;
            gameOn = true;
            gameMode = Mode.RESTING;

            String nombreUsuario;
            do {
                nombreUsuario = pantallaInicio();
            } while (nombreUsuario.length() == 0);

            load(nombreUsuario);

            // ATENCION! - REPL SIN COMPLETAR

        } while (repeatGame);
        gameOn = false;
    }

    /** Muestra pantalla inicio
     * @return String con el nombre del jugador introducido
     */
    private static String pantallaInicio() {
        String toret;
        Scanner datainput = new Scanner(System.in);

        System.out.print(ES.boxMsg("Introduce tu nombre",true));
        toret = datainput.nextLine();

        return toret;
    }

    /** Carga inicial del programa
    * @param nombreUsuario Nombre del jugador
    */
    private static void load(String nombreUsuario) {
        Mesa mesa = new Mesa();
        Jugador jugador = new Jugador(nombreUsuario);
        // Otros constructores de arranque

        ES.box(mesa);
    }

    // Verificaciones para apilar

    /** Verifica si una carta puede ser colocada encima de otra
     * @param toStack Carta a apilar
     * @param stackOn Ultima carta de la pila en la que se quiere colocar
     * @param zonaExterior true: El destino esta en la zona exterior
     *      *              / false: El destino esta en la zona interior
     * @return true: Se puede colocar encima
     *         / false: No se puede colocar encima
     */
    public static boolean stackable(Carta toStack, Carta stackOn, boolean zonaExterior) {
        boolean toret = false;
        if (zonaExterior) {
            if (stackOn.getPalo() == toStack.getPalo()
                    && stackOn.getValor() + 1 == toStack.getValor()) {
                toret = true;
            }
        } else {
            if (stackOn.getPalo() == toStack.getPalo()
                    && stackOn.getValor() == toStack.getValor() + 1) {
                toret = true;
            }
        }
        return toret;
    }
}
