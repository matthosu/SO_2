
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class Sheluder {
    LinkedList<Proces> czasowaLista1;
    LinkedList<Proces> czasowaLista2;
    LinkedList<Proces> czasowaLista3;
    LinkedList<Proces> czasowaLista4;
    Dysk readerCSCAN;
    Dysk readerFCFS;
    Dysk readerSSTF;
    Dysk readerSCAN;
    CSCAN kolejkaCSCAN;
    FCFS kolejkaFCFS;
    SCAN kolejkaSCAN;
    SSTF kolejkaSSTF;
    public Sheluder(int rozmiarDysku){
        czasowaLista1 = new LinkedList<Proces>();
        czasowaLista2 = new LinkedList<Proces>();
        czasowaLista3 = new LinkedList<Proces>();
        czasowaLista4 = new LinkedList<Proces>();
        readerCSCAN = new Dysk(rozmiarDysku);
        readerFCFS = new Dysk(rozmiarDysku);
        readerSSTF = new Dysk(rozmiarDysku);
        readerSCAN = new Dysk(rozmiarDysku);
        kolejkaCSCAN = new CSCAN(readerCSCAN);
        kolejkaFCFS = new FCFS();
        kolejkaSSTF = new SSTF();
        kolejkaSCAN = new SCAN();
    }
    public void setCzasowka(LinkedList<Proces> prezent){
        czasowaLista1 = prezent;
        czasowaLista2 = prezent;
        czasowaLista3 = prezent;
        czasowaLista4 = prezent;
    
    }
    public boolean sendToProcesor(){     //
        int licznik = 0;                // zmienna pomocnicza przy sprawdzaniu czy proces się wykonał
        if(!kolejkaCSCAN.isEmpty()){
            licznik = readerCSCAN.przetworz(kolejkaCSCAN.get());
            
            kolejkaCSCAN.increaseTotal(licznik);
            while(czasowaLista1.getFirst().getTime() < kolejkaCSCAN.getTotal()){
                kolejkaCSCAN.add(czasowaLista1.remove());
            }
        }
        if(!kolejkaFCFS.isEmpty()){
            
            licznik = readerFCFS.przetworz(kolejkaFCFS.get());
            
            kolejkaFCFS.increaseTotal(licznik);
            while(czasowaLista2.getFirst().getTime() < kolejkaFCFS.getTotal()){
                kolejkaFCFS.add(czasowaLista2.remove());
            }
        }
        if(!kolejkaSSTF.isEmpty()){
        
            licznik = readerSSTF.przetworz(kolejkaSSTF.get());
            
            kolejkaSSTF.increaseTotal(licznik);
            while(czasowaLista3.getFirst().getTime() < kolejkaSSTF.getTotal()){
                kolejkaSSTF.add(czasowaLista3.remove());
            }
            
        }
        if(!kolejkaSCAN.isEmpty()){
        
            licznik = readerSCAN.przetworz(kolejkaSCAN.get());
            
            kolejkaSCAN.increaseTotal(licznik);
            while(czasowaLista4.getFirst().getTime() < kolejkaSCAN.getTotal()){
                kolejkaSCAN.add(czasowaLista4.remove());
            }
        }
        boolean anything = (!kolejkaCSCAN.kolejka.isEmpty() || !kolejkaFCFS.kolejka.isEmpty()|| !kolejkaSCAN.kolejka.isEmpty()|| !kolejkaSSTF.kolejka.isEmpty()); // zmienna pomocnicza pozwalająca sprawdzić
        return anything;                                                                                         //czy zostały jeszcze jakiekolwiek procesy na którejkolwiek liście
    }
    public void printTimes(int liczbaProcesow){
        System.out.println("całkowita odległość pokonana przez głowicę dla CSCAN: "  +   kolejkaCSCAN.getTotal());
        System.out.println("całkowita odległość pokonana przez głowicę dla FCFS: "  +   kolejkaFCFS.getTotal());
        System.out.println("całkowita odległość pokonana przez głowicę dla SCAN: "  +   kolejkaSCAN.getTotal());
        System.out.println("całkowita odległość pokonana przez głowicę dla SSTF: "  +   kolejkaSSTF.getTotal());
    }
    

}
