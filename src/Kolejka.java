
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
    private int totalDistance;
    public Kolejka(){
        totalDistance = 0;
        kolejka = new LinkedList<Proces>();
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
    public void increaseTotal(int dist){
        totalDistance+= dist;
    }
    public int getTotal(){
        return totalDistance;
    }
    
}
