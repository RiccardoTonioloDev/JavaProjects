package javaapplication2;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author ricca
 */
public class FromClientThread implements Runnable{
    Socket socket;
    Scanner dalClient;
    
    public FromClientThread(Socket socket){
        try{
            this.socket = socket;
            dalClient = new Scanner(socket.getInputStream());
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
    
    public void run(){
        String messaggio = "";
        while(!messaggio.equals("fine")){
            if(dalClient.hasNextLine()){
                messaggio = dalClient.nextLine();
                if(!messaggio.equals("")){
                    System.out.println("[CLIENT]: ->"+messaggio+"<-");
                }
            } 
        }
        System.out.println("--- [CONNESSIONE INTERROTTA DAL CLIENT] ---");
    }
}
