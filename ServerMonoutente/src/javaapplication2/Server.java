package javaapplication2;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author ricca
 */
public class Server {
    ServerSocket server;
    Socket connessione;
    Thread dalClient;
    Thread alClient;
    
    public Server(){
        try{
            server = new ServerSocket(5005);
            connessione = server.accept();
            System.out.println("[SERVER ATTIVO]");
            dalClient = new Thread(new FromClientThread(connessione));
            alClient = new Thread(new ToClientThread(connessione));
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void conversazione(){
        dalClient.start();
        alClient.start();
    }
}
