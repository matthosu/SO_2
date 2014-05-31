/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Piotrek
 */
public class Page {
    private int modB;
    private int num;
    
    public Page(int n){
        num = n;
        modB = 0;
    }
    public void setModB(int b){
        modB = b;
    }
    public int getModB(){
        return modB;
    }
}
