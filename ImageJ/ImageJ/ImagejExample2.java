package ImageJ;


import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;
public class ImagejExample2 {
    public static void main(String[] args) {
        ImagePlus image = IJ.openImage("C:\\Users\\madha\\OneDrive\\Pictures\\Camera Roll 1\\Wallpaper download\\macbook-pro-m2-6016x3757-8612.jpg");

        if(image == null){
            System.out.println("Image could not be loaded. check the file path.");
            return;
        }
        image.show();
        ImageProcessor imageProcessor = image.getProcessor();

        imageProcessor = imageProcessor.convertToByte(true); // conversion is done on 8 bit grayscale image.
        // this means eachh pixel will be represented by a single byte(0-255), where 0 is for black and 255 is for white.


        if(imageProcessor == null){
            System.out.println("Image Processor conversion failed.");
            return;
        }

        image.setProcessor(imageProcessor);

        image.updateAndDraw();

    }
}
