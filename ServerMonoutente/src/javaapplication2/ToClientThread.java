package javaapplication2;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author ricca
 */
public class ToClientThread implements Runnable{
    Socket socket;
    PrintStream alClient;
    Scanner tastiera;
    
    public ToClientThread(Socket socket){
        try{
            this.socket = socket;
            alClient = new PrintStream(this.socket.getOutputStream());
            tastiera = new Scanner(System.in);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void run(){
        String messaggio = "";
        while(!messaggio.equals("fine")){
            messaggio = tastiera.nextLine();
            alClient.println(messaggio);
        }
        System.out.println("[CONNESSIONE INTERROTTA DAL SERVER");
    }
}
