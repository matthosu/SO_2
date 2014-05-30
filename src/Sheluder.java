
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
    RAM ramOPT;
    RAM ramFIFO;
    RAM ramLRU;
    RAM ramALRU;
    RAM ramRand;
    LinkedList<Proces> lista;
    OPT kolejkaOPT;
    FIFO kolejkaFIFO;
    LRU kolejkaLRU;
    ALRU kolejkaALRU;
    Rand kolejkaRand;
    public Sheluder(int rozmiarRAMu, LinkedList<Proces>prezent){
        ramOPT = new RAM(rozmiarRAMu);
        ramFIFO = new RAM(rozmiarRAMu);
        ramLRU = new RAM(rozmiarRAMu);
        ramALRU = new RAM(rozmiarRAMu);
        ramRand = new RAM(rozmiarRAMu);
        kolejkaOPT = new OPT();
        kolejkaFIFO = new FIFO();
        kolejkaLRU = new LRU();
        kolejkaALRU = new ALRU();
        kolejkaRand = new Rand();
        lista = new LinkedList(prezent);
    }
    public void dodanieDoRAMu(){
       
    }
    public boolean sendToDisk(){     //
        dodanieDoList();
        int licznik = 0;                // zmienna pomocnicza przy sprawdzaniu czy proces się wykonał
        if(!kolejkaCSCAN.isEmpty()){
            licznik = readerCSCAN.przetworz(kolejkaCSCAN.get(readerCSCAN.poz()));
            
            kolejkaCSCAN.increaseTotal(licznik);
            
        }
        if(!kolejkaFCFS.isEmpty()){
            licznik = readerFCFS.przetworz(kolejkaFCFS.get());
            
            kolejkaFCFS.increaseTotal(licznik);
            
        }
        if(!kolejkaSSTF.isEmpty()){
            licznik = readerSSTF.przetworz(kolejkaSSTF.get(readerCSCAN.poz()));
            kolejkaSSTF.increaseTotal(licznik);
            
            
        }
        if(!kolejkaSCAN.isEmpty()){
            licznik = readerSCAN.przetworz(kolejkaSCAN.get(readerCSCAN.poz()));
            kolejkaSCAN.increaseTotal(licznik);
            
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
