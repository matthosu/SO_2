/**
 * Instancje tej klasy symulują prace procesora "przetwarzając" procesy poprzez
 * skrócenie ich długości. Posiadają one dwa pola : clock oraz cycle. Nowy 
 * proces może zostać wczytany jedynie na początku cylku procesora (faza fetch). 
 * @author Piotrek
 */
public class Dysk {
    private int obecny;
    private final int max;
    public Dysk(int last){
        obecny = 1;
        max = last;
    }
    
    /**
     * Przetwarza proces przesuwając głowicę na odpowiedni sektor dysku
     * @param proc
     * @return int
     */
    public int przetworz(Proces proc){
        int temp = Math.abs(proc.getLoc() - obecny);
        obecny = proc.getLoc();
        return temp;
    }
    
}
