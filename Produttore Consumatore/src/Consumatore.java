/**
 *
 * @author ricca
 */
public class Consumatore implements Runnable{
    private Buffer buffer;
    
    public Consumatore(Buffer buffer){
        this.buffer = buffer;
    }
    
    public void run(){
        for(int i = 0;i<10;i++){
            System.out.println(buffer.getValore());
        }
    }
}
