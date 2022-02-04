/**
 *
 * @author ricca
 */
public class Test {
    public static void main (String[]args){
        Buffer risorsa = new Buffer();
        Thread consumatore = new Thread(new Consumatore(risorsa));
        Thread produttore = new Thread(new Produttore(risorsa));
        produttore.start();
        consumatore.start();
        
    }
}
