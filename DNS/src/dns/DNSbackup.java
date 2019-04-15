
package dns;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DNSbackup extends DNS{

    private Socket main;
    DataInputStream serverin;
    
    public DNSbackup(int puerto) {
        super(puerto);
        this.connect();
        Thread input = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        String datos = serverin.readUTF();
                        convertStringToDatos(datos);
                    } catch (IOException ex) {
                    }
                }
            }
        });
        input.start();
    }
    
    public void connect(){
        try {
            main = new Socket("localhost",8888);
            serverin = new DataInputStream(main.getInputStream());
        } catch (IOException ex) {
        }
    }
    
    public void convertStringToDatos(String aux){
        HashMap<String,InetAddress> datosT = new HashMap();
        String url;
        InetAddress ip;
        
        while (aux.indexOf("?") != -1) {            
            url = aux.substring(0,aux.indexOf("?"));
            aux = aux.substring(aux.indexOf("?")+1);        
            try {
                ip = InetAddress.getByName(aux.substring(0,aux.indexOf("+")));
                aux = aux.substring(aux.indexOf("+")+1);

                datosT.put(url, ip);
            } catch (UnknownHostException ex) {
            }
        }
        this.setDatos(datosT);
    }
    
    public static void main(String[] args) {
        DNSbackup backup = new DNSbackup(8889);
    }
    
}
