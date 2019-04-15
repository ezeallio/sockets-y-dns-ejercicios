package socketscliente; 
  
import java.net.*; 
import java.io.*; 
import java.util.logging.Level; 
import java.util.logging.Logger; 

public class Socketservidor { 
      
    public static void main (String[] args) 
    { 
        ServerSocket servidor; 
        DataOutputStream envia; 
        DataInputStream recibe;
        
        try { 
            servidor = new ServerSocket(8888); 
          
            System.out.println("Ponemos a la espera de una conexión"); 
            
            Socket socketCliente = servidor.accept(); 
  
            System.out.println("Nos pidieron la conexión.."); 
            recibe = new DataInputStream(socketCliente.getInputStream());
            envia = new DataOutputStream(socketCliente.getOutputStream()); 
              
              
            envia.writeUTF("bienvenido al servidor"); 
            
            System.out.println(recibe.readUTF());
                    
            envia.close(); 
            socketCliente.close(); 
            servidor.close(); 
              
        } catch (IOException ex) { 
            Logger.getLogger(Socketservidor.class.getName()).log(Level.SEVERE, null, ex); 
        } 
  
  
    } 
      
      
}