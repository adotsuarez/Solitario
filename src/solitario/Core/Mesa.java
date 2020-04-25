/*
* Representa la mesa de juego, donde estarán todas las cartas.
* Tendrá dos partes diferenciadas:
* - la parte interior, donde inicialmente estarán colocadas las cartas correctamente para jugar al solitario
* - los montones exteriores, donde estarán colocadas las cartas por palo ordenadas de menor a mayor
* Estructura: Se utilizarán TADs adecuados para su respresentación. En concreto:
* - Una matriz de Pilas para representar la parte o montón interior 
* - Un array de Pilas para representar los montones exteriores.
* Funcionalidad: colocar las cartas para iniciar el juego, quitar una carta de la parte interior, colocar una carta en el interior,
* colocar una carta en el montón exterior correspondiente, visualizar cartas en la mesa, etc

La Pila es una estructura de datos que existe en Java y que se corresponde con la clase Stack. Por lo tanto debereis hacer uso de dicha
clase para representar la mesa de juego, y en particular de los métodos que se indican a continuación (de ser necesarios):

        public boolean empty();
        // Produce: Si la pila está vacía devuelve true, sino false.
        public Carta peek();
        // Produce: Devuelve la Carta del tope de la pila, sin eliminarla de ella.
        public Carta pop();
        // Produce: Elimina la Carta del tope de la pila y la devuelve.
        public void push(Carta toPush);
        // Produce: Introduce la Carta en el tope de la pila.
 */
package solitario.Core;

import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author
 * - Iago Sanchez Garcia, '@LeeroyMerlin'
 * - Manuel Alejandro Silva Cheda, '@AlejandroCheda'
 * - Cristina Lavadores Pedrosa, '@TinaP5'
 * - Agustin Suarez Martinez, '@adotsuarez' [PM]
 *
 */
public class Mesa {
    private Stack<Carta> [][] montonInterior;
    private Stack<Carta> [] montonExterior;

    /** Constructor de una mesa con cartas aleatorias
     */
    public Mesa () {
        Baraja baraja = new Baraja();

        baraja.barajar();

        montonInterior = new Stack [4][4];
        montonExterior = new Stack [4];

        int pos = 0;    // Posicion a extraer de baraja

        // Primeras 16 cartas
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                montonInterior [row][col] = new Stack<>();
                push(baraja.cartaAt(pos++),row,col);
            }
        }

        // Diagonales
        for (int d = 0; d < 4; d++) {
            push(baraja.cartaAt(pos++),d,d);
        }
        for (int d = 0; d < 4; d++) {
            push(baraja.cartaAt(pos++),(3-d),d);
        }

        // Ultimas 16 cartas
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                push(baraja.cartaAt(pos++),row,col);
            }
        }

        // Zona exterior
        for (int stack = 0; stack < 4; stack++) {
            montonExterior [stack] = new Stack<>();
        }
    }

    /** Devuelve si la pila esta vacia
     * @param row Fila de la zona interior
     * @param col Columna de la zona interior
     * @return true: Esta vacia
     *         / false: No esta vacia
     */
    public boolean empty(int row, int col) {
        return montonInterior[row][col].empty();
    }

    /** Devuelve si la pila esta vacia
     * @param stack Numero (0-3) del stack exterior
     * @return true: Esta vacia
     *         / false: No esta vacia
     */
    public boolean empty(int stack) {
        return montonExterior[stack].empty();
    }

    /** Devuelve si la carta en una posicion (no se elimina)
     * @param row Fila de la zona interior
     * @param col Columna de la zona interior
     * @return Carta en esa posicion
     */
    public Carta peek (int row, int col){
        return montonInterior[row][col].peek();
    }

    /** Devuelve si la carta en una posicion (no se elimina)
     * @param stack Numero de stack exterior
     * @return Carta en esa posicion
     */
    public Carta peek(int stack){
        return montonExterior[stack].peek();
    }

    /** Devuelve si la carta en una posicion y la elimina
     * @param row Fila de la zona interior
     * @param col Columna de la zona interior
     * @return Carta en esa posicion
     */
    public Carta pop(int row, int col){
        return montonInterior[row][col].pop();
    }

    /** Devuelve si la carta en una posicion y la elimina
     * @param item Carta a introducir
     * @param row Fila de la zona interior
     * @param col Columna de la zona interior
     */
    public void push(Carta item, int row, int col){
        montonInterior[row][col].push(item);
    }

    /** Devuelve si la carta en una posicion y la elimina
     * @param item Carta a introducir
     * @param stack Numero de stack exterior
     */
    public void push(Carta item, int stack){
        montonExterior[stack].push(item);
    }

}
