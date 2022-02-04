package javaapplication2;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author ricca
 */
public class FromServerThread implements Runnable{
    Socket socket;
    Scanner dalServer;
    
    public FromServerThread(Socket socket){
        try{
            this.socket = socket;
            dalServer = new Scanner(socket.getInputStream());
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
    
    public void run(){
        String messaggio = "";
        while(!messaggio.equals("fine")){
            if(dalServer.hasNextLine()){
                messaggio = dalServer.nextLine();
                if(!messaggio.equals("")){
                    System.out.println("[SERVER]: ->"+messaggio+"<-");
                }
            } 
        }
        System.out.println("--- [CONNESSIONE INTERROTTA DAL SERVER] ---");
    }
}
