/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class FIFO extends Kolejka {
    public FIFO(){
        super();
    }
    
    @Override
    public void add(Proces proc){
        kolejka.add(proc);
    }
    public Proces get(){
        return kolejka.remove();
    }
}
