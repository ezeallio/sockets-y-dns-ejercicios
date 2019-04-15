
package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
       
        ServerSocket servidor; //creamos un servidor
        DataOutputStream envia; 
        DataInputStream recibe;
        Socket cliente; //creamos el cliente para darle permisos luego
        
        try { 
            
            servidor = new ServerSocket(8888); //definimos el puerto a usar
            System.out.println("Ponemos a la espera de una conexión");
            int suma = 0;
            
            for (int i = 0; i < 5; i++) {
                
            cliente = servidor.accept(); //damos permiso de conexion al cliente
            
            
            envia = new DataOutputStream(cliente.getOutputStream()); 
            envia.writeUTF("Bienvenido, ingrese 3 digitos:"); //enviamos mensaje
            
            recibe = new DataInputStream(cliente.getInputStream());
            suma += Integer.parseInt(recibe.readUTF()); //recibe mensaje y lo guarda en el acumulador
            
            recibe = new DataInputStream(cliente.getInputStream());
            suma += Integer.parseInt(recibe.readUTF());
            
            recibe = new DataInputStream(cliente.getInputStream());
            suma += Integer.parseInt(recibe.readUTF());
            
            envia = new DataOutputStream(cliente.getOutputStream()); 
            envia.writeUTF(Integer.toString(suma));  //envia la suma total
            
            suma = 0;
            }
            
        } catch (IOException ex) { 
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
    }
    
}
