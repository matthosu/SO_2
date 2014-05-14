/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class Sheluder {
    Dysk readerCSCAN;
    Dysk readerFCFS;
    Dysk readerSSTF;
    Dysk readerSCAN;
    CSCAN kolejkaCSCAN;
    FCFS kolejkaFCFS;
    SCAN kolejkaSCAN;
    SSTF kolejkaSSTF;
    public Sheluder(int rozmiarDysku){
        readerCSCAN = new Dysk(rozmiarDysku);
        readerFCFS = new Dysk(rozmiarDysku);
        readerSSTF = new Dysk(rozmiarDysku);
        readerSCAN = new Dysk(rozmiarDysku);
        kolejkaCSCAN = new CSCAN(readerCSCAN);
        kolejkaFCFS = new FCFS();
        kolejkaSSTF = new SSTF();
        kolejkaSCAN = new SCAN();
    }
    public void add(Proces proc){               //dodaje proces, do każdej z 4 list
        kolejkaCSCAN.add(new Proces(proc.getTime(), proc.getLoc()));
        kolejkaFCFS.add(new Proces(proc.getTime(), proc.getLoc()));
        kolejkaSSTF.add(new Proces(proc.getTime(), proc.getLoc()));
        kolejkaSCAN.add(new Proces(proc.getTime(), proc.getLoc()));
     }
    public boolean sendToProcesor(){     //
        int licznik = 0;                // zmienna pomocnicza przy sprawdzaniu czy proces się wykonał
        if(!kolejkaCSCAN.isEmpty()){
            licznik = readerCSCAN.przetworz(kolejkaCSCAN.get());
            
            kolejkaCSCAN.increaseTotal(licznik);
            
        }
        if(!kolejkaFCFS.isEmpty()){
            
            licznik = readerFCFS.przetworz(kolejkaFCFS.get());
            
            kolejkaFCFS.increaseTotal(licznik);
        }
        if(!kolejkaSSTF.isEmpty()){
        
            licznik = readerSSTF.przetworz(kolejkaSSTF.get());
            
            kolejkaSSTF.increaseTotal(licznik);
            
        }
        if(!kolejkaSCAN.isEmpty()){
        
            licznik = readerSCAN.przetworz(kolejkaSCAN.get());
            
            kolejkaSCAN.increaseTotal(licznik);
            
        }
        boolean anything = (!kolejkaCSCAN.kolejka.isEmpty() || !kolejkaFCFS.kolejka.isEmpty()|| !kolejkaSCAN.kolejka.isEmpty()|| !kolejkaSSTF.kolejka.isEmpty()); // zmienna pomocnicza pozwalająca sprawdzić
        return anything;                                                                                         //czy zostały jeszcze jakiekolwiek procesy na którejkolwiek liście
    }

}
