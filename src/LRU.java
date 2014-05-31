
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class LRU extends Kolejka{
    private RAM memory;
    private LinkedList<Proces> lista;
    public LRU(RAM mem, LinkedList<Proces> lis){
        super();
        memory = mem;
        lista = lis;
    }
    
    @Override
    public void errorHandle(Page page){
        super.increaseError();
        int spr = 0;
        int pom = 0;
        for(int i = 0; i < memory.getSize(); i++){
            for(int j = 0; j < lista.size(); j++){
                if(lista.get(j).contains(memory.get(i))&& spr < lista.get(j).lastTimeUsed(memory.get(i))){
                    spr = lista.get(j).lastTimeUsed(memory.get(i));
                    pom = i;
                }
            }
        }
        memory.set(pom, page);
    }
    
}
