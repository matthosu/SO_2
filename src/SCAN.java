/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class SCAN extends Kolejka {
    private Dysk odebrany;
    private boolean czyRosn;
    public SCAN(Dysk jakis){
        super();
        czyRosn = true;
        odebrany = jakis;
    }
    public Proces get(int pozycjaGlowicy){
        if(!kolejka.isEmpty()){
            Proces temp;
            int i = 0;
            if(czyRosn){
                while(i < kolejka.size()&&pozycjaGlowicy > kolejka.get(i++).getLoc());
                if(i+1>=kolejka.size()){
                    temp = kolejka.removeLast();
                }else{ 
                    temp = kolejka.remove(i);
                }
                if(i == kolejka.size()-1){
                    increaseTotal(odebrany.przesunNaMax());
                    czyRosn = false;
                }
            }else{
                i = kolejka.size()-1;
                while(i >0 && pozycjaGlowicy < kolejka.get(i--).getLoc());
                if(i-1>=0){
                    temp = kolejka.removeLast();
                }else{ 
                    temp = kolejka.remove(i);
                }
                if(i == 0){
                    increaseTotal(odebrany.przesunNaMin());
                    czyRosn = true;
                }
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