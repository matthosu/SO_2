
import java.util.LinkedList;

 /**
 * Instancje tej klasy symulują procesy zawierające lilstę odwołań do stron
 * oraz moment ich pojawienia się.
 * @author Piotrek
 */
public class Proces {
    
    private Page[] pageList;
    private LinkedList<Page> pages; // Odwołania do kolejnych stron
    private LinkedList<Page> used; 
    
    /**
     * Tworzy proces o zadanej ilości stron + n/7 stroy dla zakłócenia lokalności 
     * odwołań. Odwołania postaci [1,2,...,7, + n/7*(1,2,...7,) +  n/7 rand]
     */
    public Proces(int ammount){
        pageList = new Page[7];
        pages = new LinkedList();
        used = new LinkedList();
        for(int i = 0; i <7; i++){
            pageList[i] = new Page(i, this);
            pages.add(pageList[i]);
        }
        int j = ammount/7;
        for(int i = 0; i < j; i++){ 
            for(int k = 0; k <7; k++){
                pages.add(pageList[i]);
            }
        }
        // Dodanie n/7 stron dla zakłócenia lokalnosci odwaolan
        for(int i = 0; i <= j; i++){    
            pages.add((int) (Math.random()*pages.size()), pageList[(int) (Math.random()*7)]);
        }
    }
    
    /**
     * Tworzy proces o zadanej ilości stron + 2 stroy dla zakłócenia lokalności 
     * odwołań. Odwołania postaci [1,2,...,5,1,2,...5, + 2 rand]
     */
     public Proces(){
        pageList = new Page[5];
        pages = new LinkedList();
        used = new LinkedList();
        for(int i = 0; i < 5; i++){
            pageList[i] = (new Page(i, this));
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
        Page tmp = pages.remove(0);
        used.add(0,tmp);
        tmp.setModB(1);
        return tmp;
    }

    public int lastTimeUsed(Page p){
        int tmp = Integer.MAX_VALUE;
        for(int i = 0; i < used.size();i++){
            if(used.get(i) == p){
                tmp = i+1;
                break;
            }
        }
        return tmp;
    }
    public int timeToGo(Page p){
        int time = -1;
        for(int i = 0; i< pages.size(); i++){
            if(pages.get(i).equals(p)){
                 time = i;
                 break;
            }
        }
        return time;
    }
    public boolean contains(Page p){
        boolean contains = false;
        for(Page tmp : pageList){
            if(tmp.equals(p)){
                contains = true;
            }
        }
        return contains;
    }
    public boolean isDone(){
        return pages.isEmpty();
    }
    
}