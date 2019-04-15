/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telefonodescompuesto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class Cliente2 {
    public static void main(String[] args) {
        
        Socket cliente;
        Socket cliente1;
        DataInputStream recibe;
        DataOutputStream envia;
        String dato1;
        
        try{
        cliente = new Socket("localhost",8889); 
        System.out.println("Ya nos conectamos como cliente..."); 
            recibe = new DataInputStream(cliente.getInputStream()); 
            envia= new DataOutputStream(cliente.getOutputStream());
            System.out.println("nos conectamos");
            
            
            dato1=recibe.readUTF();
            
            System.out.println(dato1);         
            
            cliente.close();
            
            cliente1= new Socket("localhost",8888);
            envia= new DataOutputStream(cliente1.getOutputStream());
            recibe = new DataInputStream(cliente1.getInputStream()); 
            
            envia.writeUTF(dato1);
            
            
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
}
    

