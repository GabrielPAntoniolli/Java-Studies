
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {

    
    public boolean isVowel(char ch){
    
    char  lch = Character.toLowerCase(ch);
        if(lch == 'a' || lch == 'e' || lch == 'i' || lch == 'o' || lch == 'u'){
        
        return true;
        }
    
    return false;
    }
    
    public void testIsVowel(){
    char ch = 'a';
    char ch2 = 'b';
    System.out.println(isVowel(ch) + "" + isVowel(ch2));
    }
    
    public String replaceVowels(String phrase, char ch){
    
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< phrase.length(); i++){
        
            char a = phrase.charAt(i);
            if(isVowel(a) == true){
            sb.insert(i,ch);
        }else{
            sb.insert(i,a);
            
            
            }
            
        }
        
        return sb.toString();
        }
        
        public void testReplaceVowels(){
        
        System.out.println(replaceVowels("Gabriel Antoniolli",'*'));
        
        }
        
        public String emphasize(String phrase ,  char ch){
        
        
            StringBuilder sb = new StringBuilder();
            char x = Character.toLowerCase(ch);
        for(int i = 0; i< phrase.length(); i++){
            char b = phrase.charAt(i); 
            char c = Character.toLowerCase(b);
            
                if(i % 2 == 0 && x == c){
                sb.insert(i,'+');
                }      
                else if (i % 2 == 1 && x == c){
                sb.insert(i,'*');
                }
            else{
            sb.insert(i,b);
        }
                    
    }
        
        return sb.toString();
        }
        
        public void testEmphasize(){
        
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
        emphasis("Mary Bella Abracadabra", 'a');
        }
        
         public static String emphasis(String phrase, char ch) {
        
        StringBuilder sb = new StringBuilder();
        char x = Character.toLowerCase(ch);
        for(int i =0; i < phrase.length(); i++ ) {
           char b = phrase.charAt(i) ;
           char c = Character.toLowerCase(b);
           if(i%2==0 && x == c) {
               sb.insert(i, '*');
           } else if(i%2 == 1 && x == c) {
               sb.insert(i, '+');
           } else {
               sb.insert(i, b);
           }   
        }
        System.out.println(sb);
        return sb.toString();
        
    }

    public static void main(String[] args) {
        // TODO code application logic here

        
        emphasis("Mary Bella Abracadabra", 'a');
    }
    }

