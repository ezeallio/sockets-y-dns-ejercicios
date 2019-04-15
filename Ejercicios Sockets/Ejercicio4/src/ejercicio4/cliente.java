/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6-1user12
 */
public class cliente {
    public static void main(String[] args) {
        
        BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
        Socket cliente;
        DataInputStream recibe;
        DataOutputStream envia;
        
        try{
        cliente = new Socket("localhost",8888); 
        System.out.println("Ya nos conectamos como cliente..."); 
            recibe = new DataInputStream(cliente.getInputStream()); 
            envia= new DataOutputStream(cliente.getOutputStream());
                    
            System.out.println(recibe.readUTF());         
            
            envia.writeUTF(teclado.readLine());
            
            System.out.println(recibe.readUTF());      

        }
        catch (UnknownHostException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
}