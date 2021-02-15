
/**
 * Write a description of CharacterInPlayFinal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class CharacterInPlayFinal {
    
    private ArrayList<String> names;
    private ArrayList<Integer> counts;
    
    public CharacterInPlayFinal(){
    
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update(String person){
    
       int index = names.indexOf(person);
       if(index == -1){
        names.add(person);
        counts.add(1);
        }
       else{
        
        int valueOfIndex = counts.get(index);
        counts.set(index,valueOfIndex + 1);
        }
    }

    public void findAllCharacters(){
        names.clear();
        counts.clear();
        String name = "";
        FileResource fr = new FileResource();
        for(String line : fr.lines()){
            line = line.toLowerCase();
            int indexOfLine = line.indexOf(".");
        
            if(indexOfLine != -1){
                name = line.substring(0,indexOfLine);
                update(name);
            }
        }
    
    }
    public void CharactersWithNumParts(int num1, int num2){
    
    findAllCharacters();
    for(int i = 0; i < counts.size(); i++){
    if(counts.get(i) >= num1 && counts.get(i) <= num2){
    System.out.println(names.get(i) + "\t" + counts.get(i));
        
    }
    }
    }
    
    public void tester(){
    findAllCharacters();
    for(int i = 0; i < names.size(); i++ ){
        if(counts.get(i) > 1){
    System.out.println(names.get(i) + "\t" + counts.get(i));
    }
    }
    }
}