
/**
 * Write a description of CaesarChipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CaesarChipher {

    
    public String encrypt(String input, int key){
    
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetU = "abcdefghijklmnopqrstuvwxyz";
        String encryptedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        String encryptedAlphabetU = alphabetU.substring(key) + alphabetU.substring(0,key);
        
        for(int i = 0; i < encrypted.length(); i++){
        
            char currChar = encrypted.charAt(i);
            if(Character.isUpperCase(currChar) == true){
            int index = alphabet.indexOf(currChar);
                if(index != -1){
                char newChar = encryptedAlphabet.charAt(index);
                
                encrypted.setCharAt(i,newChar);
                }
            }else{
            int index = alphabetU.indexOf(currChar);
                if(index != -1){
                char newChar = encryptedAlphabetU.charAt(index);
                
                encrypted.setCharAt(i,newChar);
                }
           }
        }
        return encrypted.toString();
    }
    
    public void testEncrypt(){
    
    System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15));
    }
    
    
   private String encryptTwoKeys(String input, int key1, int key2){
    
    StringBuilder encrypted = new StringBuilder(input);
        String alphabetU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetL = "abcdefghijklmnopqrstuvwxyz";
        
        String encryptedAlphabetU1 = alphabetU.substring(key1) + alphabetU.substring(0,key1);
        String encryptedAlphabetU2 = alphabetU.substring(key2) + alphabetU.substring(0,key2);
        
        String encryptedAlphabetL1 = alphabetL.substring(key1) + alphabetL.substring(0,key1);
        String encryptedAlphabetL2 = alphabetL.substring(key2) + alphabetL.substring(0,key2);
        
    for(int i = 0; i < encrypted.length(); i++){
          
             char currChar = encrypted.charAt(i);
             
             if(Character.isUpperCase(currChar) == true) {
                  int index = alphabetU.indexOf(currChar);
              if(index != -1 && i % 2 == 0){
                    char newChar = encryptedAlphabetU1.charAt(index);
                    encrypted.setCharAt(i,newChar);
                }else
                if(index != -1 && i % 2 == 1){
                    char newChar = encryptedAlphabetU2.charAt(index);
                    encrypted.setCharAt(i,newChar);
                }
             }else{
        int index = alphabetL.indexOf(currChar);
          if(index != -1 && i % 2 == 0){
                    char newChar = encryptedAlphabetL1.charAt(index);
                    encrypted.setCharAt(i,newChar);
        }else
            if(index != -1 && i % 2 == 1){
                    char newChar = encryptedAlphabetL2.charAt(index);
                    encrypted.setCharAt(i,newChar);
        }
    }
    }
        return encrypted.toString();
 }

public void testTwoKeys(){

System.out.println(encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21,8));

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

public String decrypt(String encrypted){

int[] freqs = countLetters(encrypted);
int maxIndex = maxIndex(freqs);
int dkey = maxIndex - 4;
if(maxIndex < 4){
dkey = 26 - (4 - maxIndex);  

}

return encrypt(encrypted,26-dkey);
}

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

public void testDecrption(){

System.out.println("teste encription:  " + encrypt("tenho muitas esperancas de que um dia eu irei longe",17));
System.out.println("teste decryption: " + decrypt(encrypt("tenho muitas esperancas de que um dia eu irei longe",17)));


}

public String halfString(String message, int start){

    String newMessage= "";
    int i = 0;
    for(i = start; i < message.length(); i+= 2){
        newMessage = newMessage + message.charAt(i);

    }
return newMessage;
}


public int getKey(String s){

int[] counts = countLetters(s);
int maxDex = maxIndex(counts);
int key = maxDex - 4;
if(key < 4){
key = 26 - (4 - maxDex);
} 

return key;
}

public String decryptTwoKeys(String encrypted){

String a = halfString(encrypted,0);
String b = halfString(encrypted,1);

int keyA = getKey(a);
int keyB = getKey(b);

System.out.println("the keys are: " + keyA + " " + keyB);

String newImputA = encrypt(a, 26 - keyA);
String newImputB = encrypt(a, 26 - keyB);

int n1 = newImputA.length();
int n2 = newImputB.length();
String newImput = "";
        if(n1 > n2){
            for(int i = 0 ; i < n2; i++){
            newImput = newImput + newImputA.substring(i, i+1);
            newImput = newImput + newImputB.substring(i, i+1);
            }
        newImput = newImput + newImputA.substring(n1 - 1, n1);
        }
    
        if (n1 == n2) {
                for (int i = 0; i < n2; i++) {
                    newImput = newImput + newImputA.substring(i, i+1);
                    newImput = newImput + newImputB.substring(i, i+1);
                }
        }
        
        if (n1 < n2) {
            for (int i = 0; i < n1; i++) {
                newImput = newImput + newImputA.substring(i, i+1);
                newImput = newImput + newImputB.substring(i, i+1);
            }
            newImput = newImput + newImputB.substring(n2-1, n2);
        }
        
        return newImput;
}

public void testDecryptionTwoKey(){

FileResource fr = new FileResource();
String encrypted =fr.asString();
System.out.println(decryptTwoKeys(encrypted));
//System.out.println(decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));


}


}

