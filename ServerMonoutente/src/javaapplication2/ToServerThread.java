package javaapplication2;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author ricca
 */
public class ToServerThread implements Runnable{
    Socket socket;
    PrintStream alServer;
    Scanner tastiera;
    
    public ToServerThread(Socket socket){
        try{
            this.socket = socket;
            alServer = new PrintStream(this.socket.getOutputStream());
            tastiera = new Scanner(System.in);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void run(){
        String messaggio = "";
        while(!messaggio.equals("fine")){
            messaggio = tastiera.nextLine();
            alServer.println(messaggio);
        }
        System.out.println("[CONNESSIONE INTERROTTA DAL CLIENT");
    }
}
