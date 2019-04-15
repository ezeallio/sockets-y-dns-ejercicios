
package dns;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DNSmain extends DNS{

    private Socket backup;
    private DataOutputStream serverout;
    private ServerSocket server;
    
    public DNSmain(int puerto) {
        super(puerto);
        this.server = this.getServerSocket();
        this.connectBackup();
    }   
    
    public void connectBackup(){
        Thread threadBackup = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    backup = server.accept();
                    serverout = new DataOutputStream(backup.getOutputStream());
                    while(true){
                        serverout.writeUTF(convertDatosToString());
                        Thread.sleep(10000);
                    }
                } catch (IOException ex) {
                } catch (InterruptedException ex) {
                }
            }
        });
        threadBackup.start();
    }
    
    public String convertDatosToString(){
        String aux = "";
        for (Object d : this.getDatos().keySet()) {
            aux += d + "?" + this.getDatos().get(d) + "+";
        }
        aux = aux.substring(0, aux.length()-1);
         
        return aux;
    }
    
    public static void main(String[] args) {
        DNSmain main = new DNSmain(8888);
    }
    
}
