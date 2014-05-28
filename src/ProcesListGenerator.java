import java.util.LinkedList;

/**
 * Zadaniem metod tej klasy jest wygenerowanie uporządkowanej według czasu 
 * wejścia listy Procesów.
 * @author Piotrek
 */

public class ProcesListGenerator {
    
    /**
     * Tworzy listę o zadanej długości zawierającą procesy o 5 stronach i 
     * 12 odwołaniach i o losowym czasie wejścia
     * @param arrayLength
     * @return LinkedList
     */    
    public LinkedList<Proces> _12Generate(int arrayLength){
        LinkedList<Proces> list = new LinkedList();
        int safeClock = 0;
        
        for(int i=0; i < arrayLength; i++){
            list.add(new Proces( (int) (Math.random() * safeClock)));
            safeClock += 6;
        }
        System.out.print("\n_12Generate ");
        return sort(list);
    }
    /**
     * Tworzy listę o zadanej długości zawierającą procesy zawierajace 7 stron 
     * i zadaną liczbę odwołań i o losowym czasie wejścia
     * @param arrayLength
     * @return LinkedList
     */    
    public LinkedList<Proces> pseudoRandGenerate(int arrayLength, int ammount){
        LinkedList<Proces> list = new LinkedList();
        int safeClock = 0;
        
        for(int i=0; i < arrayLength; i++){
            list.add(new Proces( (int) (Math.random() * safeClock), ammount) );
            safeClock += 7;
        }
        System.out.print("\npseudoRandGenerate ");
        return sort(list);
    }
    
    
    /**
     * Otrzymuje listę procesów, porządkuje ją według czasów wejścia procesu,
     * zwraca posortowaną listę
     * @param list
     * @return LinkedList
     */
    private LinkedList<Proces> sort(LinkedList<Proces> list){
        
        LinkedList<Proces> tempList = new LinkedList();
        tempList.add(list.remove(0));
        int i;
        for(Proces proc : list){
            for(i = 0; i < tempList.size() && !(proc.getTime() < tempList.get(i).getTime()); i++);
            tempList.add(i, proc);  
        }
        
        System.out.println("dla " + tempList.size() + " procesów");
        return tempList;
    }   
}
