
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class Part1 {
    
    public void totalBirth(){
    int totalBirth = 0;
    FileResource fr = new FileResource();
    int totalGirls = 0;
    int totalBoys = 0;
    
        for(CSVRecord record : fr.getCSVParser(false)){
        
        int numBirth = Integer.parseInt(record.get(2));
        totalBirth += numBirth;
        if(record.get(1).equals("M")){
        
            totalBoys += numBirth;
        }else{
            totalGirls += numBirth;
        }
        }
    
    System.out.println("this is the total of birth: " + totalBirth);
    System.out.println("this is the total of boys: " + totalBoys);
    System.out.println("this is the total of girls: " + totalGirls);
    
    }
    
    public String dataFile(int year){
    String file = null;
        if(year == 2012){
        file = "testing/yob2012short.csv";
        return file;
        }
        if(year == 2013){
        file = "testing/yob2013short.csv";
        return file;
        }
        if(year == 2014){
        file = "testing/yob2014short.csv";
        return file;
        }
        
    return "ERROR";
    }
    
    public int getRank(int year, String name, String gender){
    String file = null;
    int rankMale = 1;
    int rankFemale = 1;
   
    FileResource fr = new FileResource(dataFile(year));
   
     for(CSVRecord rec : fr.getCSVParser(false)){
            
        if(gender.equals("F")){
            if(rec.get(1).equals(gender)){
                if(rec.get(0).equals(name)){
                    
                    return rankFemale;
                    
                }else{
        
                    rankFemale = rankFemale + 1;
                }
                
            }
        }else{
            if(rec.get(1).equals(gender)){
                if(rec.get(0).equals(name)){
                   
                    return rankMale;
                    
                }else{
        
                    rankMale = rankMale + 1;
                }
            }
        }
    }
    return -1;
    }
    
    public void testGetRank(){
    
    System.out.println("This is the rank of the chosen name: " + getRank(2012,"Emily","F"));
    
    }
    
   public String getName(int year, int rank, String gender){
  
    int countF = 0;
    int countM = 0;
    String name;
    FileResource fr = new FileResource(dataFile(year));
    
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(gender.equals("F")){ 
                if(rec.get(1).equals(gender))
                countF = countF + 1;
                    if(countF == rank){
                    name = rec.get(0);
                    return name;
                    }
            }else{
                if(rec.get(1).equals(gender)){
                countM = countM + 1;
                    if(countM == rank){
                    name = rec.get(0);
                    return name;
                    }
                }
        
            }
        }
    return "Error";
    }
    
    public void testGetName(){
    
    System.out.println("in the rank ... this is the name : " + getName(2014,4,"M"));
    
    
    }
    
    
    public String whatIsNameInYear(String name, int year, int newYear, String gender){
    
   int rank = getRank(year,name,gender);
   if(rank == -1){
    return "Name not found";
    }
   String newName = getName(newYear,rank,gender);
   
   return newName;
    
   }
   
   public void testWhatIsNameInYear(){
    
    System.out.println(whatIsNameInYear("Susan",1972,2014,"F"));
    }
    
    public int yearOfHighestRank(String name, String gender){
    int rank = 50;
    int currRank = 0;
    int year = 0;
    DirectoryResource dr = new DirectoryResource();
    for(File f : dr.selectedFiles()){
    FileResource fr = new FileResource(f);
    
    int currYear = Integer.parseInt(f.getName().substring(3,7));
    
    for(CSVRecord rec : fr.getCSVParser(false)){
    
        currRank = getRank(currYear,name,gender);
        if(currRank != -1 && rank > currRank){
        rank = currRank;
        year = currYear;
        }
        
        }
    }
         if(year != -1){
            return year;
            }
        return 0;
        
    
    }
    
public void testYearOfHighestRank(){

    System.out.println("this is the year of the  highest rank of the name Mason: " + yearOfHighestRank("Mason","M"));

}

public double getRankAverage(String name, String gender){
int currRank = 0;
int totalRank = 0;
double avg = 0;
    DirectoryResource dr = new DirectoryResource();
    for(File f : dr.selectedFiles()){
    FileResource fr = new FileResource(f);
    
    int currYear = Integer.parseInt(f.getName().substring(3,7));

    
    currRank = getRank(currYear,name,gender);
  
    totalRank += currRank;

}

if(totalRank == -1){
return -1;
} 
avg = totalRank / 3;
return avg;
}


public void testGetRankAverage(){

System.out.println("This is the average of Mason: " + getRankAverage("Mason", "M"));
}


    
}
    
    

