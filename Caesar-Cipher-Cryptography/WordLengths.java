
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class WordLengths {

    public void countWordLengths(FileResource resource, int[] counts){
    
    
        for(String s: resource.words()){
            char firstChar = s.charAt(0);
            char lastChar = s.charAt(s.length() - 1);
            int wordLength = s.length();
            if(!Character.isLetter(lastChar)){
            wordLength -=  1;
            }
            if(!Character.isLetter(firstChar)){
            wordLength -= 1;
            }
            if(wordLength > 0 && wordLength < 30){
            counts[wordLength] += 1;
            }
            
            System.out.println(wordLength + "\t" + s);
        }
            for(int i = 0; i < counts.length; i++){
            
                   if(counts[i] > 0 ){
                    
                    System.out.println(counts[i] + " words with length " + i);
                   }
            }
   }
    
   public void testCountWordLengths(){
    
    FileResource fr = new FileResource();
    int[] counts = new int[31];
    countWordLengths(fr,counts);
   }
 
  
}
    
    

