/*
* Representa la baraja española, 40 cartas, 4 palos, valores de las cartas de 1 a 12 (excepto 8 y 9). 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: estando la baraja desordenada, devolverá la carta situada encima del montón de cartas
 */
package solitario.Core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static solitario.Core.Carta.LIMITE_CARTA_NUMERO;

/**
 *
 * @author
 * - Iago Sanchez Garcia, '@LeeroyMerlin'
 * - Manuel Alejandro Silva Cheda, '@AlejandroCheda'
 * - Cristina Lavadores Pedrosa, '@TinaP5'
 * - Agustin Suarez Martinez, '@adotsuarez' [PM]
 *
 */
public class Baraja {

    // Atributos
    private Carta cartas[];

    /** Limite de cartas (limite de valor * numero de palos)
     */
    public static final int NUM_CARTAS = LIMITE_CARTA_NUMERO * Palos.values().length;

    /** Constructor de una baraja
     */
    public Baraja() {
        this.cartas = new Carta[NUM_CARTAS];
        crearBaraja(); //Creamos la baraja
    }

    /** Crea la baraja ordenada
     */
    private void crearBaraja() {

        int pos = 0;

        // Recorre los palos
        for (Palos palo : Palos.values()) {
            // Recorre los numeros
            for (int valor = 0; valor < LIMITE_CARTA_NUMERO; valor++) {
                cartas[pos++] = new Carta(valor, palo);
            }
        }

    }

    /** Devuelve la carta en una posicion
     * @param pos Posicion pedida
     * @return Carta en esa pos
     */
    public Carta cartaAt(int pos) {
        return cartas[pos];
    }

    /** Baraja todas las cartas
     */
    public void barajar() {

        // Creamos una lista
        List<Carta> listaCartas = Arrays.asList(cartas);

        // La barajamos
        Collections.shuffle(listaCartas);

        // Lo devolvemos al vector
        listaCartas.toArray(cartas);
    }
}
