/*
 * Representa una carta, formada por un número y su palo correspondiente
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
public class Carta {

    /** Limite de valor
     */
    public static final int LIMITE_CARTA_NUMERO = 10;

    private int numero;
    private Palos palo;

    /** Constructor de una carta
     * @param numero El valor de la nueva carta (0-9)
     * @param palo El palo de la nueva carta
     */
    public Carta(int numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    /** Devuelve el valor de la carta
     * @return Entero con valor de la carta (0-9)
     */
    public int getNumero() {
        return numero;
    }

    /** Devuelve el palo de la carta
     * @return Palo de la carta
     */
    public Palos getPalo() {
        return palo;
    }

    /** Devuelve la carta en formato de 3 char
     * @return String con la carta
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" ");

        if (numero <= 6) {      // 1 (As) - 7
            sb.append(numero + 1)
                    .append(" ");
        } else {                // 10 (Sota) - 12 (Rey)
            sb.append(numero + 3);
        }

        sb.append(palo.toString().charAt(0))
                .append(" ");

        return sb.toString();
    }
    
}
