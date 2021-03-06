
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class FIFO extends Kolejka {
    private RAM memory;
    int licznik;
    public FIFO(RAM mem){
        super();
        memory = mem;
        licznik = 0;
    }
    
    @Override
    public void errorHandle(Page page){
        super.increaseError();
        memory.set(licznik++, page);
        if(licznik == memory.getSize()){
            licznik = 0;
        }
    }
    
}
