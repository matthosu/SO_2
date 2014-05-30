import java.util.LinkedList;

/**
 * Zadaniem metod tej klasy jest wygenerowanie uporządkowanej według czasu 
 * wejścia listy Procesów.
 * @author Piotrek
 */

public class ProcesListGenerator {
    
    /**
     * Tworzy listę o zadanej długości zawierającą procesy o 12 stronach oraz 
     * losowym czasie wejścia
     * @param arrayLength
     * @return LinkedList
     */    
    public LinkedList<Proces> _12Generate(int arrayLength){
        LinkedList<Proces> list = new LinkedList();
        
        for(int i=0; i < arrayLength; i++){
            list.add(new Proces());
        }
        System.out.print("\n_12Generate ");
        return list;
    }
    /**
     * Tworzy listę o zadanej długości zawierającą procesy o zadanej ilości stron 
     * oraz losowym czasie wejścia
     * @param arrayLength
     * @return LinkedList
     */   
    public LinkedList<Proces> pseudoRandGenerate(int arrayLength, int ammount){
        LinkedList<Proces> list = new LinkedList();
        
        for(int i=0; i < arrayLength; i++){
            list.add(new Proces( ammount) );
        }
        System.out.print("\npseudoRrandGenerate ");
        return list;
    }   
}
