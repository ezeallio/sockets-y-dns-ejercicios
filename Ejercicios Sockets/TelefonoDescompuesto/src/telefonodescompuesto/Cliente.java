/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telefonodescompuesto;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6-1user12
 */
public class Cliente{
    public static void main(String[] args) {
        
        Socket cliente;
        Socket cliente1;
        DataInputStream recibe;
        DataOutputStream envia;
        String dato;
        
        try{
        cliente = new Socket("localhost",8888); 
        System.out.println("Ya nos conectamos como cliente..."); 
            recibe = new DataInputStream(cliente.getInputStream()); 
            envia= new DataOutputStream(cliente.getOutputStream());
                 //Cliente recibe el dato de la clase Servidor
            dato= recibe.readUTF();
            
            System.out.println(dato);         
            
            //cierra la conexion con la clase Servidor
            cliente.close();
            //hace una conexion con otro servidor
            cliente1= new Socket("localhost",8889);
            recibe = new DataInputStream(cliente1.getInputStream()); 
            envia= new DataOutputStream(cliente1.getOutputStream());
            //envia el dato a la clase Servidor2
            envia.writeUTF(dato);
            
            
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
}