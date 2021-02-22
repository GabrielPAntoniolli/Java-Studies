
/**
 * Write a description of GeneReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class GeneReader {

    
    private HashMap<String,Integer> map;
    
    public GeneReader(){
    
     map = new HashMap<String,Integer>();
    
    }
    
    public void buildCodonMap(int start, String dna){
    map.clear();
    int numOfCodons = (dna.length() - start)/3;
    String currCodon = "";
    
        for(int i = 0; i < numOfCodons; i++){
        
            currCodon = dna.substring(start+ i*3 , start+ i*3+ 3); 
            
                if(!map.containsKey(currCodon)){
                map.put(currCodon,1);
                }
                else{
                    map.put(currCodon,map.get(currCodon) + 1);
            
                }
        }
    }
    public String getMostCommonCodon(){
    int mapCount = 0;
    int currValue = 0;
    String largestCodon = "";
    
        for(String codon : map.keySet()){
            currValue = map.get(codon);
            if(currValue > mapCount){
            mapCount = currValue;
            largestCodon = codon;
            
            }
        }
    return largestCodon;
    }
    
    public void printCodonCounts(int start, int end){
    
        for(String codon : map.keySet()){
            if(map.get(codon)>= start && map.get(codon) <= end){
            System.out.println(codon + "\t" + map.get(codon));
            
            }
        }
    }
    
    public void tester(){
    
    FileResource fr = new FileResource();
    String dna = fr.asString().trim();
    dna = dna.toUpperCase();
    
    System.out.println("frame 0");
    buildCodonMap(0,dna);
    System.out.println("number of unique codons in the map: " + map.size());
    System.out.println("number of the most common codon in the map: " + getMostCommonCodon() + "\t" + map.get(getMostCommonCodon()));
    System.out.println("codons and its numbers of occurences when between 2 numbers: ");
    printCodonCounts(0,3);
    System.out.println();
    
    System.out.println("frame 1");
    buildCodonMap(1,dna);
    System.out.println("number of unique codons in the map: " + map.size());
    System.out.println("number of the most common codon in the map: " + getMostCommonCodon() + "\t" + map.get(getMostCommonCodon()));
    System.out.println("codons and its numbers of occurences when between 2 numbers: ");
    printCodonCounts(0,3);
    System.out.println();
    
    System.out.println("frame 2");
    buildCodonMap(2,dna);
    System.out.println("number of unique codons in the map: " + map.size());
    System.out.println("number of the most common codon in the map: " + getMostCommonCodon() + "\t" + map.get(getMostCommonCodon()));
    System.out.println("codons and its numbers of occurences when between 2 numbers: ");
    printCodonCounts(0,3);
    System.out.println();
    
    }
}