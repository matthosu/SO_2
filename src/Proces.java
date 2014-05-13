 /**
 * Instancje tej klasy symulują procesy wskazując na sektor dysku do którego 
 * proces się odwołuje oraz moment jego pojawienia się.
 * @author Piotrek
 */
public class Proces {
    
    private int location;
    private int entryTime;
    
    /**
     * Tworzy proces rządający dostępu do określonego (losowego) miejsca w pamięci
     * ustawiając jego czas wejścia na otrzymaną wartość.
     */
    public Proces(int time, int loc){
        location = loc;
        entryTime = time;
    }
    
    public int getLoc(){
        return location;
    }
    public int getTime(){
        return entryTime;
    }
    
}