/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telefonodescompuesto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Servidor2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ServerSocket servidor;
        DataOutputStream envia;
        DataInputStream recibe;
             Socket Cliente;
        String dato;
        
        try{
        servidor= new ServerSocket(8889);
            System.out.println("espera de clientes");
             
            Cliente= servidor.accept();
            recibe = new DataInputStream(Cliente.getInputStream());
            envia= new DataOutputStream(Cliente.getOutputStream());
           
           
               
            dato=recibe.readUTF();
        
            
            Cliente.close();
            
            
            servidor.accept();
            System.out.println("hay conexion");
                     
                                   
            envia.writeUTF(dato);
            
            System.out.println("envio de server2");
        }
        catch(IOException ex) { 
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }
}
