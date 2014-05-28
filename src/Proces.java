
import java.util.LinkedList;

 /**
 * Instancje tej klasy symulują procesy zawierające lilstę odwołań do stron
 * oraz moment ich pojawienia się.
 * @author Piotrek
 */
public class Proces {
    
    private Page[] pageList;
    private LinkedList<Page> pages; // Odwołania do kolejnych stron
    private int entryTime;
    
    /**
     * Tworzy proces o (n) zadanej ilości stron + n/7 stron dla zakłócenia lokalności 
     * odwołań. Odwołania postaci [1,2,...,7, + n/7*(1,2,...7,) +  n/7 rand]
     */
    public Proces(int time, int ammount){
        entryTime = time;
        pageList = new Page[7];
        pages = new LinkedList();
        for(int i = 0; i <7; i++){
            pageList[i] = new Page(i);
            pages.add(pageList[i]);
        }
        int j = ammount/7;
        for(int i = 1; i < j; i++){ 
            for(int k = 0; k <7; k++){
                pages.add(pageList[k]);
            }
        }
        // Dodanie n/7 stron dla zakłócenia lokalnosci odwaolan
        for(int i = 0; i <= j; i++){    
            pages.add((int) (Math.random()*pages.size()), pageList[(int) (Math.random()*7)]);
        }
    }
    
    /**
     * Tworzy proces o 10 stronach + 2 strony dla zakłócenia lokalności 
     * odwołań. Odwołania postaci [1,2,...,5,1,2,...5, + 2 rand]
     */
     public Proces(int time){
        entryTime = time;
        pageList = new Page[5];
        pages = new LinkedList();
        for(int i = 0; i < 5; i++){
            pageList[i] = (new Page(i));
            pages.add(pageList[i]);
            
        }
        for(int i = 0; i < 5; i++){     
            pages.add(pageList[i]);
        }
        // Dodanie 2 stron dla zakłócenia lokalnosci odwaolan
        pages.add((int) (Math.random()*9)+1, pageList[(int) (Math.random()*5)]);
        pages.add((int) (Math.random()*10)+1, pageList[(int) (Math.random()*5)]);
    }
    
    public Page getPage(){
        return pages.remove(0);
    }
    public int getTime(){
        return entryTime;
    }
    
}