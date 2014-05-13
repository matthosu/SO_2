/**
 * Instancje tej klasy symulują prace dysku przyznając do niego dostęp poprzez 
 * przesunięcie "głowicy" do wskazanego sektora 
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
    public int poz(){
        return obecny;
    }
}
