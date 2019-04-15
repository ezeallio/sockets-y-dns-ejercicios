/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.net.ServerSocket;

import java.io.*;
import java.net.*;
import java.net.ServerSocket;

import java.util.ArrayList;
import java.util.logging.Level; 
import java.util.logging.Logger; 

/**
 *
 * @author 6-1user12
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Socket Cliente;
        ServerSocket servidor;
        DataOutputStream envia;
        DataInputStream recibe;
        ArrayList<String> nombre= new ArrayList();
        ArrayList<Socket> clientes = new  ArrayList();
//               recibe = new DataInputStream(servidor.getInputStream());
        try{
        servidor= new ServerSocket(8888);
            System.out.println("espera de clientes");
             
            for (int i = 0; i < 4; i++) {
                Cliente=servidor.accept();
                clientes.add(Cliente);
                envia = new DataOutputStream(clientes.get(i).getOutputStream());
                envia.writeUTF("Bienvenido Ingrese su nombre y apellido");
               recibe = new DataInputStream(clientes.get(i).getInputStream());
               clientes.get(i).getInputStream();
               nombre.add(recibe.readUTF());
            }
        
                for (int j = 0; j < 4; j++) {
                envia = new DataOutputStream(clientes.get(j).getOutputStream());
                   envia.writeUTF(nombre.get(j));
            }
            
        
        }
        catch(IOException ex) { 
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }
}
