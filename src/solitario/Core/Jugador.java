/*
 * Representa al único jugador de la partida, identificado por el nombre 
 * Funcionalidad: le da la vuelta a una carta que está boca abajo, escoge una carta para moverla o al montón de descarte
 *                o la mueve encima de otra carta del interior
 */
package solitario.Core;

/**
 *
 * @author
 * - Iago Sanchez Garcia, '@LeeroyMerlin'
 * - Manuel Alejandro Silva Cheda, '@AlejandroCheda'
 * - Cristina Lavadores Pedrosa, '@TinaP5'
 * - Agustin Suarez Martinez, '@adotsuarez' [PM]
 *
 */
public class Jugador {
    private String nombre;
    private Mesa mesa;

    /** Constructor de un jugador
     * @param nombre Nombre del jugador
     */
    public Jugador(String nombre){
        this.nombre = nombre;
        this.mesa = new Mesa(nombre);
    }

    /** Devuelve si una posicion esta vacia
     * @param row Fila de la zona interior
     * @param col Columna de la zona interior
     * @return true: Esta vacia
     *         / false: No esta vacia
     */
    public boolean empty(int row, int col) {
        return mesa.empty(row,col);
    }

    /** Devuelve si una posicion esta vacia
     * @param stack Pila de la zona exterior
     * @return true: Esta vacia
     *         / false: No esta vacia
     */
    public boolean empty(int stack) {
        return mesa.empty(stack);
    }

    /** Devuelve la carta en una posicion
     * @param row Fila de la zona interior en la que se encuentra la carta pedida
     * @param col Columna de la zona interior en la que se encuentra la carta pedida
     * @return Carta pedida
     */
    public Carta viewCarta(int row, int col) {
        return mesa.peek(row,col);
    }

    /** Devuelve la carta en una posicion
     * @param stack Pila de la zona exterior en el que se encuentra la carta pedida
     * @return Carta pedida
     */
    public Carta viewCarta(int stack) {
        return mesa.peek(stack);
    }

    /** Mueve una carta a otra pila
     * @param from Origen: Coordenadas de la zona interior (fila [0] y columna [1]) como array de dos enteros
     * @param to Destino: Coordenadas de la zona interior (fila [0] y columna [1]) como array de dos enteros
     */
    public void move(int[] from, int[] to) {
        mesa.push(mesa.pop(from[0],from[1]), to[0], to[1]);
    }

    /** Mueve una carta a otra pila
     * @param from Origen: Coordenadas de la zona interior (fila [0] y columna [1]) como array de dos enteros
     * @param to Destino: Pila de la zona exterior a donde moveremos la carta
     */
    public void move(int[] from, int to) {
        mesa.push(mesa.pop(from[0],from[1]), to);
    }
}
