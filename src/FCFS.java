/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class FCFS extends Kolejka {
    public FCFS(){
        super();
    }
    @Override
    public void add(Proces proc){
        kolejka.add(proc);
    }
}
