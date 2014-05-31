
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class OPT extends Kolejka{
    private RAM memory;
    private LinkedList<Proces> lista;
    public OPT(RAM mem, LinkedList<Proces> lis){
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
            
            if(memory.get(i).getProces().timeToGo(memory.get(i)) == -1){
                pom = i;
                i = memory.getSize();
            }else if(memory.get(i).getProces().timeToGo(memory.get(i)) > spr){
                spr = memory.get(i).getProces().timeToGo(memory.get(i));
                pom = i;
            }
            
        }
        memory.set(pom, page);
    }
}
