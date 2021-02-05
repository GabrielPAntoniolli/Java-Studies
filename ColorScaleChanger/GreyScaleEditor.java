
/**
 * Write a description of GreyScaleEditor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class GreyScaleEditor {
    
    
    public ImageResource makeGrey(ImageResource inImage){
    
    ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
    
    
    for(Pixel p : outImage.pixels()){
    
    Pixel inPixel = inImage.getPixel(p.getX(),p.getY());
    
    int avg = (inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
    
    p.setBlue(avg);
    p.setRed(avg);
    p.setGreen(avg);
    
    }
    
    return outImage;
    }
    
    public void testMakeGrey(){
    
    ImageResource ir = new ImageResource();
    ImageResource greyImage = makeGrey(ir);
    String fName = greyImage.getFileName();
    String newName = "grey" + fName;
    greyImage.setFileName(newName);
    greyImage.draw();
    greyImage.save();
    
    }
    
    public void multipleMakeGrey(){
    
    DirectoryResource dr = new DirectoryResource();
    
    for(File f : dr.selectedFiles()){
    ImageResource ir = new ImageResource(f);
    ImageResource greyImage = makeGrey(ir);
    greyImage.draw();
    
    
    }
    
    }

}
