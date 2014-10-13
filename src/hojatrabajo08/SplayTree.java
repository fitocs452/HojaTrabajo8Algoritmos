
package hojatrabajo08;

/**
 *
 * @authors Adolfo, Luis
 * 
 */

public class SplayTree implements WordSet {
         
    private SplayNode nodoRaiz = null;
    private int count = 0;


    //Función para llenar el árbol
    public void add(Word valorIngresado ){

        //Nodos 
        SplayNode nodoEvaluar = nodoRaiz;
        SplayNode nodoIng = null;

        //Verificamos el tipo de nodo que es y se le da un valor
        while (nodoEvaluar != null){

        nodoIng = nodoEvaluar;
            //Se compara el valor de los nodos y se define si es menor o mayor
            if (nodoIng.palabra.compareTo(valorIngresado)>0){
                nodoEvaluar = nodoEvaluar.nodoDerecho;}
            else{
                nodoEvaluar = nodoEvaluar.nodoIzquierdo;}

        }

        //Creamos un nuevo nodo, que se ingresara al arbol
        nodoEvaluar = new SplayNode();
        nodoEvaluar.palabra = valorIngresado;
        nodoEvaluar.nodoPadre = nodoIng;
        
        if (nodoIng == null){
            nodoRaiz = nodoEvaluar;}

        //Se define si es nodo con valor mayor o menor
        else if (nodoIng.palabra.compareTo(valorIngresado) > 0){
            nodoIng.nodoDerecho = nodoEvaluar;}

        else{
            nodoIng.nodoIzquierdo = nodoEvaluar;}

        //Se verifica si hay una rotacion
        Splay(nodoEvaluar);

        count++;

    }

    // Rotacion Zig del arbol
    public void rotacionZig(SplayNode nodoHijo, SplayNode nodoPadre){
        
        boolean errorInstancia = false;
        boolean errorArbol = false;
        
        //Se verifica si los nodos son instancias
        if (nodoHijo!=null || nodoPadre!=null){
            errorInstancia = true;
        }
        //si existen entonces se verifica si estan asociados en el arbol
        if(nodoPadre.nodoIzquierdo!= nodoHijo || nodoHijo.nodoPadre != nodoPadre){
            errorArbol = true;
        }

        if (errorInstancia == false && errorArbol == false){
            //Se verifica el nodo padre para la primera rotacion
            if (nodoPadre.nodoPadre != null){
                if (nodoPadre == nodoPadre.nodoPadre.nodoIzquierdo){
                    nodoPadre.nodoPadre.nodoIzquierdo = nodoHijo;}
                else{ 
                    nodoPadre.nodoPadre.nodoDerecho = nodoHijo;}
            }

            if (nodoHijo.nodoDerecho != null){
                nodoHijo.nodoDerecho.nodoPadre = nodoPadre;}

            //Se hace la rotacion
            nodoHijo.nodoPadre = nodoPadre.nodoPadre;
            nodoPadre.nodoPadre = nodoHijo;
            nodoPadre.nodoIzquierdo = nodoHijo.nodoDerecho;
            nodoHijo.nodoDerecho = nodoPadre;
        }
    }

 

    //Rotación Zag del arbol
    public void rotacionZag(SplayNode nodoHijo, SplayNode nodoPadre){

        boolean errorInstancia = false;
        boolean errorArbol = false;
        
        //Se verifica si los nodos son instancias
        if (nodoHijo!=null || nodoPadre!=null){
            errorInstancia = true;
        }
        //si existen entonces se verifica si estan asociados en el arbol
        if(nodoPadre.nodoDerecho!= nodoHijo || nodoHijo.nodoPadre != nodoPadre){
            errorArbol = true;
        }

        if (errorInstancia == false && errorArbol == false){
            //Se verifica el nodo padre para la primera rotacion
            if (nodoPadre.nodoPadre != null){
                if (nodoPadre == nodoPadre.nodoPadre.nodoIzquierdo){
                    nodoPadre.nodoPadre.nodoIzquierdo = nodoHijo;}
                else{
                    nodoPadre.nodoPadre.nodoDerecho = nodoHijo;}
            }

            if (nodoHijo.nodoIzquierdo != null){
                nodoHijo.nodoIzquierdo.nodoPadre = nodoPadre;}

            //Se hace la rotacion
            nodoHijo.nodoPadre = nodoPadre.nodoPadre;
            nodoPadre.nodoPadre = nodoHijo;
            nodoPadre.nodoDerecho = nodoHijo.nodoIzquierdo;
            nodoHijo.nodoIzquierdo = nodoPadre;
        }
    }

    
    //Funcion encargada de hacer el ordenamiento
    private void Splay(SplayNode nodoEvaluar){

        //Siempre que existan dos nodos juntos
        while (nodoEvaluar.nodoPadre != null){

            //Nodos
            SplayNode nodoPadre = nodoEvaluar.nodoPadre;
            SplayNode nodoAbuelo = nodoPadre.nodoPadre;

            //Si no existen dos nodos padres juntos, se hace una rotacion
            //que depende del valor del nodo ya que puede ser Zig o Zag.
            if (nodoAbuelo == null){
                if (nodoEvaluar == nodoPadre.nodoIzquierdo){
                    rotacionZig(nodoEvaluar, nodoPadre);}
                else{
                    rotacionZag(nodoEvaluar, nodoPadre);}                
            }

            //Si existen dos nodos padres
            else{
                //Si el nodo a evaluar es el nodo menor del nodo padre existen 2 posibilidades de 4 rotaciones
                //en donde el nodo que se mueve primero es el padre y luego el evaluado cuando el nodo padre es inferior
                //al nodo padre del abuelo, si es mayor el nodo padre que el abuelo entonces se mueve el nodo evaluado por el padre.
                if (nodoEvaluar == nodoPadre.nodoIzquierdo){

                    if (nodoPadre == nodoAbuelo.nodoIzquierdo){
                        rotacionZig(nodoPadre, nodoAbuelo);
                        rotacionZig(nodoEvaluar, nodoPadre);
                    }else{
                        rotacionZig(nodoEvaluar, nodoEvaluar.nodoPadre);
                        rotacionZag(nodoEvaluar, nodoEvaluar.nodoPadre);
                    }
                }else {
                    
                    if (nodoPadre == nodoAbuelo.nodoIzquierdo){
                        rotacionZag(nodoEvaluar, nodoEvaluar.nodoPadre);
                        rotacionZig(nodoEvaluar, nodoEvaluar.nodoPadre);
                    }else{
                        rotacionZag(nodoPadre, nodoAbuelo);
                        rotacionZag(nodoEvaluar, nodoPadre);
                    }
                }
            }
        }
        nodoRaiz = nodoEvaluar;

     }

    //Método que devuelve el valor de un nodo
    public Word get(Word ele){

        SplayNode nodoEvaluar = nodoRaiz;
        while (nodoEvaluar != null){

            if (nodoEvaluar.palabra.compareTo(ele)>0){
                nodoEvaluar = nodoEvaluar.nodoDerecho;}

            else if (nodoEvaluar.palabra.compareTo(ele)<0){
                nodoEvaluar = nodoEvaluar.nodoIzquierdo;}

            else{
                 return nodoEvaluar.palabra;}
        }
        return null;
    }
    
    //Método que verifica si el arbol esta vacío
    public boolean isEmpty(){
         return nodoRaiz == null;}
    
    //Metodo para limpiar arbol es decir quitar nodos
    public void clear(){
         nodoRaiz = null;
    }

    
}
