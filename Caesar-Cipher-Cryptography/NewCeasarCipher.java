
/**
 * Write a description of NewCeasarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class NewCeasarCipher {
    private    String alphabet;
    private    String encryptedAlphabet;
    private    int mainKey;
    
    public NewCeasarCipher(int key){
    
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    String encryptedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
    mainKey = key;
            
    }
    
    public String encrypt(String input){
    
        CaesarChipher gg = new CaesarChipher();
        String result = gg.encrypt(input,mainKey);
        
        
        return result;
    }
    public String decrypt(String input){
    
        NewCeasarCipher cc = new NewCeasarCipher(26-mainKey);
        return cc.encrypt(input);

    }
    
}
