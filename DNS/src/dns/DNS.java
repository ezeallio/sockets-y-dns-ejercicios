package dns;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.HashMap;

public abstract class DNS {

    private ServerSocket server;
    private HashMap<String,InetAddress> datos;

    public DNS(int puerto){
        try {
            server = new ServerSocket(puerto);
            datos = new HashMap<String,InetAddress>();
            inicio();
        } catch (IOException ex) {
        }
    }
    
    public void inicio(){
        while (true) {            
            Listener l = new Listener(this);
        }
    }
    
    public ServerSocket getServerSocket(){
        return server;
    }
    
    public HashMap<String,InetAddress> getDatos(){
        return datos;
    }
    
    public void setDatos(HashMap<String,InetAddress> value){
        this.datos = value;
    }

}
