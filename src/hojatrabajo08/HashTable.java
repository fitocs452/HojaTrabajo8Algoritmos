
package hojatrabajo08;

import java.util.HashMap;

/**
 *
 * @author Adolfo, Luis
 */
public class HashTable implements WordSet{
    
    HashMap arbol = new HashMap();
    //agregar elementos al arbol
    public void add(Word elemento){
        String palabra = elemento.getWord();
        String tipo = elemento.getType();
        arbol.put(palabra, tipo);
        
    }
    
    public Word get(Word W){
        System.out.println(":" + W.getWord() + " " + W.getType() + " " + arbol.get(W.getWord()));
        
        //Cuando se encuentra la palabra se hace el getWord
        if(arbol.containsKey(W.getWord())){
            Word palabraBus = new Word(W.getWord(),""+arbol.get(W.getWord()));
            return palabraBus;
        }else{ 
            return null;}
    }
}
