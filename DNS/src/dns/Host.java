
package dns;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Host {

    private Socket cliente;
    private DataOutputStream solicitud;
    private DataInputStream respuesta;
    private Scanner teclado;
    private int puerto;
    
    public Host(){
        teclado = new Scanner(System.in);
        this.puerto = 8888;
        this.connect();
    }
    
    public void connect(){
        try{
            cliente = new Socket("localhost",puerto);
        } catch (IOException ex){
            System.out.println("Error");
            this.puerto = 8889;
            this.connect();
        }
            
        try{
            solicitud = new DataOutputStream(cliente.getOutputStream());
            respuesta = new DataInputStream(cliente.getInputStream());
            
            System.out.println(respuesta.readUTF());
            
            solicitud.writeUTF(teclado.next());
            
            System.out.println(respuesta.readUTF());
        } catch (IOException ex){
            try {
                solicitud.close();
                respuesta.close();
                cliente.close();
            } catch (IOException ex1) {
            }
        }
    }
    
    public static void main(String[] args) {
        Host cliente = new Host();
    }
}
