package dns;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Listener {

    DataOutputStream respuesta;
    InputServidor solicitud;
    InetAddress ip;

    public Listener(DNS n) {

        System.out.println("Esperando clientes...");

        try {

            Socket cliente = n.getServerSocket().accept();
            respuesta = new DataOutputStream(cliente.getOutputStream());
            solicitud = new InputServidor(this, cliente.getInputStream());
            solicitud.start();
            System.out.println("Conectado");

            respuesta.writeUTF("Ingrese el dominio a convertir con la "
                    + "URL completa (Ejemplo: www.google.com):");

        } catch (IOException ex) {

            System.out.println("Falla de conexion");

        }
    }

    public void ip(String url) throws IOException, URISyntaxException {

        InetAddress ip;
        if(!url.startsWith("http") && !url.startsWith("https")){
                 url = "http://" + url;
        }        
        
        URI uri = new URI(url);
        String host = uri.getHost();
        if (host == null)
            throw new URISyntaxException(url, "returned null");
        
        ip = InetAddress.getByName(host);

        respuesta.writeUTF("IP: " + ip.getHostAddress());

    }
    
    
    public void cerrar(){    
        try {
            respuesta.close();
            solicitud.close();
        } catch (IOException ex) {
        }
        
    }

}
