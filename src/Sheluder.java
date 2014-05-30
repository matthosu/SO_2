
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
        kolejkaOPT = new OPT(ramOPT, lista);
        kolejkaFIFO = new FIFO(ramFIFO, lista);
        kolejkaLRU = new LRU(ramLRU, lista);
        kolejkaALRU = new ALRU(ramALRU, lista);
        kolejkaRand = new Rand(ramRand, lista);
        lista = new LinkedList(prezent, lista);
    }
    public void dodanieDoRAMu(Page page){
        if(!ramOPT.add(page)){
            kolejkaOPT.errorHandle(page);
        }
        if(!ramFIFO.add(page)){
            kolejkaFIFO.errorHandle(page);
        }
        if(!ramLRU.add(page)){
            kolejkaLRU.errorHandle(page);
        }
        if(!ramALRU.add(page)){
            kolejkaALRU.errorHandle(page);
        }
        if(ramRand.add(page)){
            kolejkaRand.errorHandle(page);
        }
    }
    public boolean sendToDisk(){     //
        dodanieDoRAMu();
        
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
