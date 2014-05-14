/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class CSCAN extends Kolejka {
    private Dysk odebrany;
    public CSCAN(Dysk odebr){
        super();
        odebrany = odebr;
    }
    public Proces get(int pozycjaGlowicy){
        if(!kolejka.isEmpty()){
            Proces temp;
            int i = 0;
            while(i < kolejka.size()&&pozycjaGlowicy > kolejka.get(i++).getLoc());
            if(i == kolejka.size()){
                increaseTotal(odebrany.przesunNaMax());
                i = 0;
            }
            temp = kolejka.remove(i);
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