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
        public void push(Carta item);
        // Produce: Introduce la Carta en el tope de la pila.
 */
package solitario.Core;

import java.util.Scanner;
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
    Scanner en = new Scanner(System.in);
    public void MovimientoInterior(){

        int c0;
        int c1;
        int f0;
        int f1;
        do{
            System.out.println("Introduce la fila y la columna de la carta a mover");
            c0 = (Integer.parseInt(en.nextLine())-1);
            c1 = (Integer.parseInt(en.nextLine())-1);
            System.out.println("Introduce la fila y la columna a donde mover la carta");
            f0= (Integer.parseInt(en.nextLine())-1);
            f1= (Integer.parseInt(en.nextLine())-1);
            
        }while(c0> -1&&c1> -1&& f0> -1&& f1> -1);


        if(!montonInterior[c0][c1].empty()||!montonInterior[f0][f1].empty()){
            if (montonInterior[c0][c1].peek().numero == 7){//supongo que carta tiene el atributo numero
                if(((montonInterior[c0][c1].peek().numero + 3) == montonInterior[f0][f1].peek().numero) && (montonInterior[c0][c1].peek().palo == montonInterior[f0][f1].peek().palo)){
                    montonInterior[f0][f1].push(montonInterior[c0][c1].pop());
                }else{
                    System.out.println("Movimiento no valido");
                }
            }else{
                if(((montonInterior[c0][c1].peek().numero + 1)== montonInterior[f0][f1].peek().numero)&&(montonInterior[c0][c1].peek().palo == montonInterior[f0][f1].peek().palo)){
                    montonInterior[f0][f1].push(montonInterior[c0][c1].pop());
                }else{
                    System.out.println("Movimiento no valido");
                }
            }
        }else{
            System.out.println("El monton seleccionado o el monton de destino esta vacio");
        }
        System.out.println(toString());
    }

    public void MovimientoExterior(){
        int c0;
        int c1;
        int f;
        do{
            System.out.println("Introduce la columna y la fila de la carta a mover");
            c0 = (Integer.parseInt(en.nextLine()) - 1);
            c1 = (Integer.parseInt(en.nextLine()) - 1);
            
            System.out.println("Introduce la fila del monton exterior");
            f = (Integer.parseInt(entrada.nextLine()) - 1);
            
        }while(c0> -1&&c1> -1&& f> -1);
        
        if(montonInterior[c0][c1].peek().numero == 1){
            
            if(montonExterior[f].empty()){
                
                montonExterior[f].push(montonInterior[c0][c1].pop());
            }else{
                System.out.println("Solo se pueden colocar Ases en posiciones vacias");
            }
        }else{
            if(!montonExterior[f].empty()){
                
                if(montonExterior[f].peek().numero == 7){
                    
                    if ((montonInterior[c0][c1].peek().numero == montonExterior[f].peek().numero + 3) && (montonInterior[c0][c1].peek().palo == montonExterior[f].peek().palo)){
                        
                        montonExterior[f].push(montonInterior[c0][c1].pop());
                    }else{
                    System.out.println("Movimiento Invalido");
                    }
                }else{
                    
                  if((montonInterior[c0][c1].peek().numero == montonExterior[f].peek().numero + 1) && (montonInterior[c0][c1].peek().palo == montonExterior[f].peek().palo)){
                      
                    montonExterior[f].push(montonInterior[c0][c1].pop());
                }else{
                    System.out.println("Movimiento Invalido");
                }
                }
            }else{
                System.out.println("Monton vacio");
            }
        }
        System.out.println(toString());
    }
}
