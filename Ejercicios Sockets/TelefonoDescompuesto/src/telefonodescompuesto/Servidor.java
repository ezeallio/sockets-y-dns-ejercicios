/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telefonodescompuesto;

import java.net.ServerSocket;

import java.io.*;
import java.net.*;
import java.net.ServerSocket;

import java.util.ArrayList;
import java.util.logging.Level; 
import java.util.logging.Logger; 

/**
 *
 * @author 6-1user12
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ServerSocket servidor;
        DataOutputStream envia;
        DataInputStream recibe;
        String dato;
        
        String datoinicial="hola";
        
        
        
        try{
            
        servidor= new ServerSocket(8888);
        
            System.out.println("espera de clientes");
             
          Socket Cliente= servidor.accept();
           
           
            recibe = new DataInputStream(Cliente.getInputStream());
            envia= new DataOutputStream(Cliente.getOutputStream());
               // envia el dato a la clase Cliente
            envia.writeUTF(datoinicial);
        
            Cliente.close();
            //se corta la conexion y espera a que entre otro cliente del cual va a recibir el dato final           
            servidor.accept();
            
            dato=recibe.readUTF();
            
            System.out.println(dato);
            
            if (dato==datoinicial) {
                System.out.println("iguales");
            }
            
        }
        catch(IOException ex) { 
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }
}