---
description: >-
  Este es un proyecto para la asignatura de Algoritmos y Estructuras de Datos 1
  [AED1] de Ingeniería Informática de la Universidad de Vigo.
---

# Solitario

El solitario es un juego de cartas para el que no necesitas a nadie más. Este solitario está pensado para esos momentos de aburrimiento o de viajes eternos. Solo necesitas una baraja española y a ti mismo.

{% hint style="warning" %}
En este proyecto se harán modificaciones de manera progresiva para mejorar su funcionamiento y eficiencia, por este motivo, **es posible que el programa no funcione por completo en algunas versiones**.
{% endhint %}

## Objetivo

Para jugar al **solitario** son necesarias **40 cartas de la baraja española**. La baraja está compuesta de 4 palos \(oros, espadas, bastos y copas\) cada uno con siete cartas enumeradas del 1 al 7 y tres figuras \(sota, caballo y rey\) correspondientes a los números 10, 11 y 12 respectivamente.

El **objetivo** del juego es comenzar con todas las cartas desordenadas y terminar con cuatro montones ordenados de menor a mayor, uno para cada palo de la baraja.

## Cómo jugar

Se colocan **16 cartas boca abajo**, formando 4 columnas y 4 filas. A continuación, se colocan **8 cartas boca abajo** encima de aquellas que están en las diagonales. Por último, se colocan **boca arriba las 16 cartas** restantes, encima de las que ya están colocadas \(a esta zona se llamará **zona-Interior**\).

El objetivo es ir quitando las cartas de la zona-interior de menor a mayor colocándolas en cuatro **montones exteriores,** \(uno para cada palo\) que han de empezar con la carta numerada con el 1.

### Reglas del juego

* Se puede mover una carta de la zona-interior al montón exterior si la última carta almacenada en el montón exterior es del mismo palo y una unidad más pequeña que la que se quiere colocar \(_fíjate que después del 7 viene el 10_\). Si debajo de ella existiese una carta boca abajo se gira para hacerla visible.
* Si el montón exterior está vacío, sólo se podrá colocar una carta que contenga un as.
* En la zona-interior se puede mover una carta sobre otra, siempre que la carta que se va a ocultar sea del mismo palo y una unidad mayor que la que se mueve \(_fíjate que encima del 10 se debe colocar un 7_\). Este movimiento tiene como objetivo hacer visible la carta que está debajo de la que se está moviendo.
* No se puede mover una carta a un hueco vacío en la zona-interior.

### Final de una partida

El juego continúa siempre que exista un movimiento posible, es decir, un movimiento de una carta a algún montón exterior o un movimiento dentro de la zona-interior. El juego puede finalizar con dos situaciones:

* **Los montones exteriores contienen todas las cartas**
  * Los cuatro montones exteriores tienen 10 cartas del mismo palo ordenados de menor a mayor. **Objetivo conseguido**.
* **No hay más movimientos posibles y quedan cartas en la zona-interior**
  * Puede ocurrir que el solitario no finalice, quedan cartas en la zona-interior y no es posible ningún movimiento. **Objetivo no conseguido**.

## 

## Creadores y licencias

* El programa fue creado originalmente _'@adotsuarez'_, _'@LeeroyMerlin'_, _'@AlejandroCheda'_ y _'@TinaP5'_.
* Para más información sobre licencias, por favor, lee el archivo LICENSE.

