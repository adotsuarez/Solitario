/*
 * Representa el juego del solitario, con sus reglas. 
 * Se recomienda una implementación modular.
 */
package solitario.IU;

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

    /** Programa principal
     */
    public static void inicioPartida(){
        boolean repeatGame;

        // REPL
        do {
            repeatGame = false;

            String nombreUsuario;
            do {
                nombreUsuario = pantallaInicio();
            } while (nombreUsuario.length() == 0);

            // ATENCION! - REPL SIN COMPLETAR

        } while (repeatGame);
    }

    /** Muestra pantalla inicio
     * @return Nombre del jugador introducido
     */
    private static String pantallaInicio() {
        String toret;
        Scanner datainput = new Scanner(System.in);

        System.out.print(ES.box("Introduce tu nombre",true));

        toret = datainput.nextLine();
        return toret;
    }

//    /** Carga inicial del programa
//     * @param nombreUsuario Nombre del jugador
//     */
//    private static void load(String nombreUsuario) {
//        Mesa mesa = new Mesa();
//        // Jugador jugador = new Jugador(nombreUsuario);
//        // Otros constructores de arranque
//
//
//    }
}
