/*
* Representa la baraja española, 40 cartas, 4 palos, valores de las cartas de 1 a 12 (excepto 8 y 9). 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: estando la baraja desordenada, devolverá la carta situada encima del montón de cartas
 */
package solitario.Core;

import java.util.Collections;
import java.util.Stack;

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
    private Stack<Carta> cartas;     // Pila mejor que array

    /** Limite de cartas (limite de valor * numero de palos)
     */
    public static final int NUM_CARTAS = LIMITE_CARTA_NUMERO * Palos.values().length;

    /** Constructor de una baraja
     */
    public Baraja() {
        crearBaraja(); // Creamos la baraja
    }

    /** Crea la baraja ordenada
     */
    private void crearBaraja() {
        // Recorre los palos
        for (Palos palo : Palos.values()) {
            // Recorre los numeros
            for (int valor = 0; valor < LIMITE_CARTA_NUMERO; valor++) {
                cartas.push(new Carta(valor, palo));
            }
        }
    }

    /** Saca la carta del tope de la baraja
     * @return Carta en el tope
     */
    public Carta sacarCarta() {
        return cartas.pop();
    }

    /** Devuelve si la baraja esta vacia
     * @return true: Esta vacia
     *         / false: No esta vacia
     */
    public boolean empty() {
        return cartas.empty();
    }


    /** Baraja todas las cartas
     */
    public void barajar() {
        Collections.shuffle(cartas);
    }
}
