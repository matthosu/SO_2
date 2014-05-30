
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Piotrek
 */

public abstract class Kolejka {
    LinkedList<Proces> kolejka;
    private int liczbaBledow;
    public Kolejka(){
        liczbaBledow = 0;
    }
    public void add(Proces proc){};
    
    public Proces remove(){
        return kolejka.remove();
    }
    public Proces get(){
        return kolejka.getFirst();
    }
    public boolean isEmpty(){
        return kolejka.isEmpty();
    }
    public void increaseError(){
        liczbaBledow++;
    }
    public int getTotal(){
        return liczbaBledow;
    }
    
}
