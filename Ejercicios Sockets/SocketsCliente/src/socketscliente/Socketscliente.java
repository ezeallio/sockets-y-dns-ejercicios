package socketscliente; 
  
import java.io.BufferedReader;
import java.io.DataInputStream; 
import java.io.DataOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.net.Socket; 
import java.util.logging.Level; 
import java.util.logging.Logger; 

public class Socketscliente { 
  
    public static void main (String[] args) 
    { 
        Socket cliente; 
        DataInputStream recibe; 
        DataOutputStream envia;
        
        BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
        
        try { 
            cliente = new Socket("localhost",8888); 
            
            System.out.println("Ya nos conectamos como cliente..."); 
            recibe = new DataInputStream(cliente.getInputStream()); 
            envia = new DataOutputStream(cliente.getOutputStream());
            
            System.out.println(recibe.readUTF());         
            
            String dato;
            dato=teclado.readLine();
            envia.writeUTF(dato);
                       
            
            
            recibe.close(); 
            cliente.close(); 
            
            
              
              
        } catch (IOException ex) { 
            Logger.getLogger(Socketscliente.class.getName()).log(Level.SEVERE, null, ex); 
        } 
  
  
    } 
      
      
} 