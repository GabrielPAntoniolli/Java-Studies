
/**
 * Write a description of countShakespeare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class countShakespeare {

    public void commomWords(){
    String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt.",
                        "likeit.txt","macbeth.txt", "romeo.txt"};
    String[] common = getCommon();
    int[] counts = new int[common.length];
     for(int i = 0; i < plays.length; i++){
        
        FileResource fr = new FileResource("testingArchives/CommonWordsData (1)/" + plays[i]);
        countWords(fr,common,counts);
        System.out.println("done with " + plays[i]);
        }
      for(int i = 0; i < common.length; i++){
        System.out.println(common[i] + "\t" + counts[i]);
        }                      
                        
    }
    
    public String[] getCommon(){
    
        FileResource fr = new FileResource("testingArchives/CommonWordsData (1)/common.txt");
        String[] common = new String [20];
        int index = 0;
        for(String s: fr.words()){
        common[index] = s;
        index += 1;
        
        }
        return common;
    
    }
    public void countWords(FileResource resource, String[] common, int[] counts){
    
    for(String word : resource.words()){
      word = word.toLowerCase();
      int index = indexOf(common,word);
      if(index != -1){
        counts[index] += 1;
        }

    }
    
    }
    
    public int indexOf(String[] list, String word){
    
    for(int i = 0; i<list.length; i++){
    
        if(list[i].equals(word)){
        return i;
        }
    }
    return -1;
    }
    
}
