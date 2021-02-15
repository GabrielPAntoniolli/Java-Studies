
/**
 * Write a description of testNewCeasarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class testNewCeasarCipher {

    
public int maxIndex(int[] freqs){
int realSave = 0;
int saveIndex = 0;
for(int i = 0; i < freqs.length; i++){
if(freqs[i] > saveIndex){
saveIndex = freqs[i];
realSave = i;
} 
}
return realSave;
}

public int[] countLetters(String message){

String alphabet = "abcdefghijklmnopqrstuvwxyz";
int[] counts = new int[26];

    for(int i = 0; i < message.length(); i++){
    
    char ch = Character.toLowerCase(message.charAt(i));
    
    int index = alphabet.indexOf(ch);
        if(index != -1 ){
        counts[index] += 1;
        }
    }
    return counts;
}

public void simpleTest(){

FileResource fr = new FileResource();
String fileContent = fr.asString();
NewCeasarCipher ncc = new NewCeasarCipher(18);

System.out.println(ncc.encrypt(fileContent));
System.out.println(ncc.decrypt(ncc.encrypt(fileContent)));

}

}
