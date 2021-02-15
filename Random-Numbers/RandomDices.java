
/**
 * Write a description of randonDices here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class randonDices {
    
    public void countOfAllNumbers(int rolls){
        
    Random rand = new Random();
    int[] count = new int[13];
    
    for(int i = 0; i<rolls; i++){
    
        int d1 = rand.nextInt(6) + 1;
        int d2 = rand.nextInt(6) + 1;
        
        count[d1+d2] += 1;
    
    }
    for(int k = 2; k <= 12; k++){
    System.out.println(k + "'s=\t" + count[k]);
    }
    
}
    
    public void numberOfTwosAndTwelves(int rolls){
        
    Random rand = new Random();
    
    int twos = 0;
    int twelves = 0;
    
    for(int i = 0; i<rolls; i++){
    
        int d1 = rand.nextInt(6) + 1;
        int d2 = rand.nextInt(6) + 1;
        
        if(d1 + d2 == 2){
        twos += 1;
        }
        if(d2 + d1 == 12){
        twelves += 1;
        }
    
        
    }
    System.out.println("this is the ocurrences of twos : " + twos + " and twelves : " + twelves );
}
    
}
