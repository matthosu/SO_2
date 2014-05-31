/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Mateusz
*/
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Main {
    public static void main(String[]args) throws FileNotFoundException{
        int iloscStron;
        int wielkoscRamu;
        int liczbaProcesow;
        Scanner sc = new Scanner(new FileReader("Test.txt"));
        
        while(sc.hasNextLine()){
                String linia = sc.nextLine();
                Scanner pom = new Scanner(linia);
                wielkoscRamu = pom.nextInt();
                liczbaProcesow = pom.nextInt();
                Sheluder shlud = new Sheluder(wielkoscRamu);
                ProcesListGenerator plg = new ProcesListGenerator();
                LinkedList<Proces> procesy = new LinkedList<>();
                switch(sc.nextInt()){
                    case 0:
                        procesy = plg._12Generate(liczbaProcesow);
                        shlud.setList(procesy);
                        System.out.println("Dla " + liczbaProcesow + " procesów");
                        shlud.execution();
                        shlud.printErrors();
                        break;
                    case 1:
                        iloscStron = sc.nextInt();
                        procesy = plg.pseudoRandGenerate(liczbaProcesow, iloscStron);
                        shlud.setList(procesy);
                        System.out.println("Dla " + liczbaProcesow + " procesów");
                        shlud.execution();
                        shlud.printErrors();
                        break;
                } 
            
        }
    }
}
