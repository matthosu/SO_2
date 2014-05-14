/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class SSTF extends Kolejka {
    public SSTF(){
        super();
    }
    public Proces get(int pozycjaGlowicy){
        if(!kolejka.isEmpty()){
            int i = 0;
            while(i < kolejka.size()&&pozycjaGlowicy > kolejka.get(i++).getLoc());
            Proces temp;
            if((pozycjaGlowicy-kolejka.get(i).getLoc()) > (kolejka.get(i+1).getLoc() - pozycjaGlowicy)){
                temp = kolejka.remove(i+1);
            }else{
                temp = kolejka.remove(i);
            }
            return temp;
        }else{
            return null;
        }
    }
    @Override
    public void add(Proces proc){
        int i = 0;
        while(i < kolejka.size()&&proc.getLoc() > kolejka.get(i++).getLoc());
        kolejka.add(i, proc);
    }
    public Proces get(){
        throw new UnsupportedOperationException("IdiotProgramistException, uzyles nie tego geta");
    }
}
    