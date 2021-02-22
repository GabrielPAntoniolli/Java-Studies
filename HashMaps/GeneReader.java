
/**
 * Assignment: Codon Count
 *Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames. A strand of DNA is made up of the symbols C, G, T, and A. A codon 
 *is three consecutive symbols in a strand of DNA such as ATT or TCC. A reading frame is a way of dividing a strand of DNA into consecutive codons. Consider the following 
 *strand of DNA = “CGTTCAAGTTCAA”.
 *
 * There are three reading frames. 
 *
 * The first reading frame starts at position 0 and has the codons: “CGT”, “TCA”, “AGT” and “TCA”. Here TCA occurs twice and the others each occur once.
 * The second reading frame starts at position 1 (ignoring the first C character) and has the codons: “GTT”, “CAA”, “GTT”, “CAA”. Here both GTT and CAA occur twice.
 * The third reading frame starts at position 2 (ignoring the first two characters CG) and has the codons: “TTC”, “AAG”, “TTC”. Here TTC occurs twice and AAG occurs once.
 * A map of DNA codons to the number times each codon appears in a reading frame would be helpful in solving this problem.
 * 
 * @ Gabriel Antoniolli 
 * 
 */
import java.util.*;
import edu.duke.*;

public class GeneReader {

    
    private HashMap<String,Integer> map;
    
    public GeneReader(){
    
     map = new HashMap<String,Integer>();
    
    }
    /*
     * Write a void method named buildCodonMap that has two parameters, an int named start and a String named dna. This method will build a new map of codons mapped to their          * counts from the string dna with the reading frame with the position start (a value of 0, 1, or 2). You will call this method several times, so make sure your map is empty      * before building it.
     */
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
   /* Write a method named getMostCommonCodon that has no parameters. This method returns a String, the codon in a reading frame that has the largest count. If there are several       such codons, return any one of them. This method assumes the HashMap of codons to counts has already been built.*/
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
    /*Write a void method named printCodonCounts that has two int parameters, start and end. This method prints all the codons in the HashMap along with their counts if their         count is between start and end, inclusive.*/
    public void printCodonCounts(int start, int end){
    
        for(String codon : map.keySet()){
            if(map.get(codon)>= start && map.get(codon) <= end){
            System.out.println(codon + "\t" + map.get(codon));
            
            }
        }
    }
    /*Write a tester method that prompts the user for a file that contains a DNA strand (could be upper or lower case letters in the file, convert them all to uppercase, since   case should not matter). Then for each of the three possible reading frames, this method builds a HashMap of codons to their number of occurrences in the DNA strand, prints the total number of unique codons in the reading frame, prints the most common codon and its count, and prints the codons and their number of occurrences for those codons whose number of occurrences in this reading frame are between two numbers inclusive.*/
    public void tester(){
    
    FileResource fr = new FileResource();
    String dna = fr.asString().trim(); // The convention for text files is to end with a line break, so "trim" fix the problem.
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
