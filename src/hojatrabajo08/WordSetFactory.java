
package hojatrabajo08;

/**
 *
 * @author Adolfo, Luis
 */

public class WordSetFactory {
    
    private static WordSet arbol;
    
    public static WordSet crearArbol(int opcionFactory){
        
        /* Se instancia el arbol en el que se desea trabajar
            1. RedBlackTree
            2. SplayTree
            3. HashTable
            4. TreeMap
        */
        
        //Creacion de Set
        switch(opcionFactory){
            case 0: arbol = new SimpleSet(); break;
            //case 1: arbol = new RedBlackTree(); break;
            case 2: arbol = new SplayTree(); break;
            case 3: arbol = new HashTable(); break;
            //case 4: arbol = new TreeMap(); break;
        }
        return arbol;
    }
	
}