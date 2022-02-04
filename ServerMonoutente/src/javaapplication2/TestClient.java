package javaapplication2;
import java.util.Scanner;
/**
 *
 * @author ricca
 */
public class TestClient {
    public static void main (String[]args){
        Scanner tastiera = new Scanner(System.in);
        String indirizzo;
        System.out.println("Inserire l'indirizzo del server a cui intendi collegarti: ");
        indirizzo = tastiera.nextLine();
        Client client = new Client(indirizzo);
        client.conversazione();
    }
}
