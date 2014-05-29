/**
 * Instancje tej klasy symulują prace pamięci RAM zapisując w tablicy strony
 * należące do wykonywanych procesów
 * @author Piotrek
 */
public class RAM {
    private Page[] ram;
    public RAM(int size){
        ram = new Page[size];
    }
    public boolean contains(Page p){
        boolean contains = false;
        for(Page tmp : ram){
            if(tmp.equals(p)){
                contains = true;
            }
        }
        return contains;
    }
    public boolean isFull(){
        return ram[ram.length-1] != null ? true : false;
    }
}
