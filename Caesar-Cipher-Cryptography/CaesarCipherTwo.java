
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class CaesarCipherTwo {

    private String alphabet;
    private String shiftedAlphabet;
    private String shiftedAlphabet2;
    private int chave1;
    private int chave2;
    
    public CaesarCipherTwo(int key1, int key2){
    
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0,key1);
    shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
    chave1 = key1;
    chave2 = key2;
    }
    
    public void encryptTwoKeys(String input){
    
    CaesarChipher cc = new CaesarChipher();
    
    System.out.println(cc.encryptTwoKeys(input,chave1,chave2));
    
    
    }
    public void decryptTwoKeys(String input){
    
        CaesarChipher cc = new CaesarChipher();
        
        System.out.println(cc.encryptTwoKeys(input,26 - chave1, 26 - chave2 ));
        
        
        
    }
    public void decryptTwoKeysfiles(){
        FileResource fr = new FileResource();
        String s = fr.asString();
        CaesarChipher cc = new CaesarChipher();
        
        System.out.println(cc.encryptTwoKeys(s,26 - chave1, 26 - chave2 ));
        
        
        
    }
}
