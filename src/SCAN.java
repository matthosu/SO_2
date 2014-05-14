/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class SCAN extends Kolejka {
    private boolean czyRosn;
    public SCAN(){
        super();
        czyRosn = true;
    }
    public Proces get(int pozycjaGlowicy){
        if(!kolejka.isEmpty()){
            Proces temp;
            int i = 0;
            if(czyRosn){
                while(i < kolejka.size()&&pozycjaGlowicy > kolejka.get(i++).getLoc());
                temp = kolejka.get(i);
            }else{
                i = kolejka.size();
                while(i >0 && pozycjaGlowicy < kolejka.get(i--).getLoc());
                temp = kolejka.get(i);
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