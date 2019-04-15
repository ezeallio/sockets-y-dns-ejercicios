

package ejercicio5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        
        ServerSocket servidor; //crear servidor
        Socket Cliente; //creamos el cliente para darle permisos luego
        DataOutputStream envia;
        DataInputStream recibe;
        ArrayList<String> nombre= new ArrayList(); //almacena los datos recibidos
        
        try{
        servidor= new ServerSocket(8888); //puerto a usar en el servidor
            System.out.println("espera de clientes");
             
            for (int i = 0; i < 4; i++) {
                Cliente=servidor.accept(); //da permiso al cliente
                envia = new DataOutputStream(Cliente.getOutputStream());
                envia.writeUTF("Bienvenido Ingrese su nombre y apellido"); //envia peticion
               recibe = new DataInputStream(Cliente.getInputStream());
               nombre.add(recibe.readUTF()); //guarda en el array nombres los datos recibidos
               
               if(i == 0) //si tal cliente esta conectado...
               {
                envia = new DataOutputStream(Cliente.getOutputStream());
                envia.writeUTF(nombre.get(0)); //...le envia los datos guardados en el array nombres
               }
               else //sino, pasara a ver si no es otro cliente
                   if(i == 1)
                   {
                       envia = new DataOutputStream(Cliente.getOutputStream());
                       envia.writeUTF(nombre.get(0) + "\n" + nombre.get(1));
                   }
               else
                   if(i == 2)
                   {
                       envia = new DataOutputStream(Cliente.getOutputStream());
                       envia.writeUTF(nombre.get(0) + "\n" + nombre.get(1) + "\n" + nombre.get(2));
                   }
               else
                   if(i == 3)
                   {
                       envia = new DataOutputStream(Cliente.getOutputStream());
                       envia.writeUTF(nombre.get(0) + "\n" + nombre.get(1) + "\n" + nombre.get(2) + "\n" + nombre.get(3));
                   }
            }
        
        }
        catch(IOException ex) { 
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
}
