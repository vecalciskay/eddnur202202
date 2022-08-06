# Práctico 1 - Ordenar

Este práctico debe presentarse el día 16 de agosto de 2022.

## Descripción del problema

El objetivo del práctico es ordenar una lista de números enteros de forma ascendente.
La forma de hacerlo es bastante peculiar por ello se la explica 
en detalle:

* El programa tiene un menú donde se da inicializar arreglo
    * La inicialización consiste en pedir al usuario el tamaño del arreglo (número entre 10,000 y 1,000,000)
    * El sistema asigna números al azar entre 0 y 100,000 a cada posición
* El programa debe permitir ordenar el arreglo
  * El ordenamiento se hace dividiendo el arreglo en 3 subarreglos. De 0 a 33000, de 33001 a 66000 y de 66001 a 100000.
  * La división se debe realizar ya que 
    * el arreglo de 0 a 33000 se debe ordenar con inserción
    * el arreglo de 33001 a 66000 se debe ordenar con burbuja
    * el arreglo de 66001 a 100000 se debe ordenar con quicksort
* El programa debe mostrar cuánto tardó en cada caso (en milisegundos)
* El programa debe tener alguna manera de demostrar que ordenó bien

Se aconseja hacer un primer pase (un for) que mueva los números
para que el arreglo quede ordenado en los 3 subarreglos en la misma
lista.