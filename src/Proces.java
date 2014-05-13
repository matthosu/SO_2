 /**
 * Instancje tej klasy symulują procesy przetrzymując (pozostałą) dłługość 
 * procesu oraz moment jego pojawienia się.
 * @author Piotrek
 */
public class Proces {
    
    private int location;
    private int entryTime;
    
    /**
     * Tworzy proces rządający dostępu do określonego (losowego) miejsca w pamięci
     * ustawiając jego czas wejścia na otrzymaną wartość.
     */
    public Proces(int time, int last){
        location = (int) (Math.random()*last) + 1;
        entryTime = time;
    }
    
    public int getLoc(){
        return location;
    }
    public int getTime(){
        return entryTime;
    }
    
}