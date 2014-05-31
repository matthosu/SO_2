
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class ALRU extends Kolejka{
    private RAM memory;
    int licznik;
    public ALRU(RAM mem){
        super();
        memory = mem;
        licznik = 0;
    }
    
    @Override
    public void errorHandle(Page page){
        super.increaseError();
        while(memory.get(licznik).getModB() == 1){
            memory.get(licznik).setModB(0);
            licznik++;
            if(licznik == memory.getSize()){
                licznik = 0;
            }
        }
        memory.set(licznik++, page);
        if(licznik == memory.getSize()){
            licznik = 0;
        }
        
        memory.set(licznik, page);
    }
    
    
}
