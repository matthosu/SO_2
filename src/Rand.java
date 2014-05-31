/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class Rand extends Kolejka {
    private RAM memory;
    public Rand(RAM mem){
        super();
        memory = mem;
    }
    
    @Override
    public void errorHandle(Page page){
        super.increaseError();
        memory.set(((int)Math.random())*memory.getSize() , page);
        
    }
    
}
