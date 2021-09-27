
/**
 * Write a description of ImageInversion here.
 * 
 * @Damilare Oyediran 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class ImageInversion {
    
    // 
    public ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
           Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY()); 
           
           int newRed = 255 - inPixel.getRed();
           int newBlue = 255 - inPixel.getBlue();
           int newGreen = 255 - inPixel.getGreen();
           
           pixel.setRed(newRed);
           pixel.setGreen(newGreen);
           pixel.setBlue(newBlue);
        }
        return outImage;
    }
    
    
    public void testImageInversion(){
        ImageResource ir = new ImageResource();
        ImageResource inverImage = makeInversion(ir);
        String fileName = inverImage.getFileName();
        String newName = "inverted-" + fileName;
        inverImage.setFileName(newName);
        inverImage.draw();
    }
    
}
