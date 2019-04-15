

package ejercicio5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        
        BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
        Socket cliente; //creamos el cliente
        DataInputStream recibe;
        DataOutputStream envia;
        
        try{
        cliente = new Socket("localhost",8888); //determinamos la ip del cliente y el puerto
        System.out.println("Ya nos conectamos como cliente..."); 
            recibe = new DataInputStream(cliente.getInputStream());
            envia= new DataOutputStream(cliente.getOutputStream());
                    
            System.out.println(recibe.readUTF()); //muestra mensaje recibido del servidor
            
            envia.writeUTF(teclado.readLine()); //envia los datos pedidos
            
            System.out.println(recibe.readUTF()); //muestra todos los datos almacenados

        }
        catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
