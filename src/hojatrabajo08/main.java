/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hojatrabajo08;

import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null, "Ingreso primero el Word.txt y luego el Text.txt");
        // TODO code application logic here
        
        /*Esto permite utilizar el WordTypeCounter sin necesidad de linea de 
            comandos*/
        
        //El archivo se carga en el orden
        // 1-Words
        // 2-Text
        
         //Argumentos a pasar al WordTypeCounter
        String[] argumentos = new String[3];
        
        //Se cargan las palabras
        AbrirArchivos archivo = new AbrirArchivos();
        archivo.Abrir();
        argumentos[0] = archivo.getPath();
        
        
        //Se carga el texto
        archivo.Abrir();
        argumentos[1]=archivo.getPath();
        
        String implementacion = JOptionPane.showInputDialog("Ingrese el numero de la implementacion\n"
                + "0.SimpleSet\n1.RedBlackTree\n2.SplayTree\n3.HashTable\n4.TreeMap");
        argumentos[2] = implementacion;
        
        
        /*Crea un objeto WordTypeCounter*/
        WordTypeCounter wtc = new WordTypeCounter(argumentos);
    }
    
}
