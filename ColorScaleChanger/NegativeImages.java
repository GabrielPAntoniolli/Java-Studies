
/**
 * Write a description of NegativeImages here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class NegativeImages {

    
    public ImageResource makeNegative(ImageResource inImage){
    
    ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
    
    for(Pixel pixel : outImage.pixels()){
    
        Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
        
        int blue = 255 - inPixel.getBlue();
        int green = 255 - inPixel.getGreen();
        int red = 255 - inPixel.getRed();
        
        pixel.setBlue(blue);
        pixel.setRed(red);
        pixel.setGreen(green);
    
    
    
    }
    
    
    return outImage;
    }
    
    public void testMakeNegative(){
    
    ImageResource ir = new ImageResource();
    ImageResource Negative = makeNegative(ir);
    String fname = Negative.getFileName();
    String newName = "Negative-" + fname;
    Negative.setFileName(newName);
    Negative.save();
    Negative.draw();
    
    
    }
    
}
