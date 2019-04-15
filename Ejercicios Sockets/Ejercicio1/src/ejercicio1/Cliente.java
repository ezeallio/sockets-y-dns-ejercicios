

package ejercicio1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        
        Socket cliente; //creamos el cliente
        DataInputStream recibe; 
        DataOutputStream envia;
        
        BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
        
        try { 
            
            cliente = new Socket("localhost",8888); //definimos la ip del cliente y el puerto al cual se conecta
            
            recibe = new DataInputStream(cliente.getInputStream()); 
            System.out.println(recibe.readUTF());      //recibe el mensaje    
            
            
            String dato;
            
            envia = new DataOutputStream(cliente.getOutputStream());
            dato=teclado.readLine();
            envia.writeUTF(dato); //envia un mensaje
            
            envia = new DataOutputStream(cliente.getOutputStream());
            dato=teclado.readLine();
            envia.writeUTF(dato);
            
            envia = new DataOutputStream(cliente.getOutputStream());
            dato=teclado.readLine();
            envia.writeUTF(dato);
                      
            recibe = new DataInputStream(cliente.getInputStream()); 
            System.out.println("La suma total es " + recibe.readUTF()); //imprime la suma        
            
            recibe.close(); 
            cliente.close(); //cierra conexion
            
            
              
              
        } catch (IOException ex) { 
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
}
