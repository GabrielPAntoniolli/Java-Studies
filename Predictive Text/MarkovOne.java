
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class MarkovOne {

    private String myText;
    private Random myRandom;

    public MarkovOne() {
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public ArrayList<String> getFollows(String key){

        ArrayList<String> follows = new ArrayList<String>();
        int index = 0;
        int pos = 0;
        String next = "";
            while(pos < myText.length() - key.length()){

                index = myText.indexOf(key,pos);
                if(index == -1){
                    break;
                }
                    
                if(index + key.length() >= myText.length()){
                        break;
                }
                
                next = myText.substring(index+key.length(),index+key.length() + 1);
                follows.add(next);
                pos = index + 1;

            }

    return follows;  
    }
    

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String next = "";
            int index = myRandom.nextInt(myText.length() - 1);
            String key = myText.substring(index, index + 1);
            sb.append(key);
        
        
        for(int k=0; k < numChars; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){
            break;
            }
            
            index = myRandom.nextInt(follows.size());
            next = follows.get(index);
            sb.append(next);
            key = next;
        }
        
        return sb.toString();
    }
}
