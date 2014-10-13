/*
Universidad del Valle de Guatemala
Hoja de Trabajo 8 
Adolfo Morales 13014
Luis Duarte 13003
Descripcion: La presente clase tiene como fin el crear un nodo asociado al concepto de un SplayTree
             en donde se tiene un nodo padre, nodo izquierdo, nodo derecho y su valor.
 */
package hojatrabajo08;

/**
 *
 * @author Adolfo, Luis
 */

public class SplayNode  {
    // Nodos
    SplayNode nodoIzquierdo;
    SplayNode nodoDerecho, nodoPadre;
    // String o palabra
    Word palabra;

    //Primer constructor con ningun parámeto
    public SplayNode(){
        this(null, null, null, null);}          

    //Segundo constructor que recibe una palabra
    public SplayNode(Word palabra){
         this(palabra, null, null, null);
    } 

    //Tercer constructor que recible la palabra y sus nodos asociados
     public SplayNode(Word palabra, SplayNode nodoIzquierdo, SplayNode nodoDerecho, SplayNode nodoPadre){

        this.nodoIzquierdo = nodoIzquierdo;
        this.nodoDerecho = nodoDerecho;
        this.nodoPadre = nodoPadre;
        this.palabra = palabra;         

     }    
    
}
