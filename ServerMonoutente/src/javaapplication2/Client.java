package javaapplication2;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author ricca
 */
public class Client {
    Socket connessione;
    Thread dalServer;
    Thread alServer;
    Scanner tastiera =new Scanner(System.in);
    
    public Client(String indirizzoIP){
            try{
                connessione = new Socket(indirizzoIP,5005);
                dalServer = new Thread(new FromServerThread(connessione));
                alServer = new Thread(new ToServerThread(connessione));
                
            }catch(UnknownHostException e){
                System.out.println("HOST NON TROVATO");
            }catch(IOException e){
                System.out.println("PROBLEMI CON L'I/O");
            }
        System.out.println("[CONNESSIONE AL SERVER AVVENUTA CON SUCCESSO]");
    }
    
    public void conversazione(){
        dalServer.start();
        alServer.start();
    }
}
