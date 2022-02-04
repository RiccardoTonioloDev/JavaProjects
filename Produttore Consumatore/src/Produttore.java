/**
 *
 * @author ricca
 */
public class Produttore implements Runnable{
    private Buffer buffer;
    
    public Produttore(Buffer buffer){
        this.buffer = buffer;
    }
    
    public void run(){
        for(int i = 0;i<10;i++){
            buffer.setValore("Numero: "+(i+1));
        }
    }
}
