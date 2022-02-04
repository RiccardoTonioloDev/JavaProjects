/**
 *
 * @author ricca
 */
public class Buffer {
    private String valore;
    /*Se lo stato buffer è a false, significa che il buffer è vuoto*/
    private boolean statoBuffer;
    
    public Buffer(){
        statoBuffer = false;
        valore = "";
    }
    
    private boolean statoDelBuffer(){
        return statoBuffer;
    }
    
    public synchronized void setValore(String cambioValore){
        while(statoDelBuffer()){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        valore = cambioValore;
        statoBuffer = true;
        notifyAll();
    }
    
    public synchronized String getValore(){
        while(!statoDelBuffer()){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        statoBuffer = false;
        notifyAll();
        return valore;
    }
}
