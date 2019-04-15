
package dns;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputServidor extends Thread{
    
    private Listener l;
    private DataInputStream in;
    
    public InputServidor(Listener l, InputStream in){
        this.l = l;
        this.in = new DataInputStream(in);
    }
    
    public void close(){
        try {
            in.close();
        } catch (IOException ex) {
        }
    }
    
    @Override
    public void run(){
        
        while(true){
            String url;
            try {
                url = in.readUTF();
                l.ip(url);
            } catch (IOException ex) {
                /*try {
                    l.cerrar();
                } catch (IOException ex1) {
                }*/
            } catch (URISyntaxException ex) {
                try {
                    System.err.println("Error de sintaxis en url: " + ex); 
                    l.respuesta.writeUTF("Error de sintaxis en url: " + ex);
                    l.cerrar();
                } catch (IOException ex1) {
                }
            }
        }
    }
            
}
