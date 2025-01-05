package ImageJ;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class ResizeImage {
    public static void main(String[] args) {
        ImagePlus image = IJ.openImage("C:\\Users\\madha\\Pictures\\3d-cartoon-style-character.jpg");

        if(image == null){
            System.out.println("Image could not be loaded. please load it again.");
            return;
        }

        System.out.println("Original height: " + image.getHeight());
        System.out.println("Original width: " + image.getWidth());

        image.show();

        ImageProcessor processor = image.getProcessor();

        if(processor == null){
            System.out.println("Image Processor object is not created.");
            return;
        }


        int newWidth = image.getWidth() / 2;
        int newHeight = image.getHeight() / 2;

        

        processor.setInterpolationMethod(ImageProcessor.BILINEAR); // for smooth resizing.

        ImageProcessor resizedProcessor = processor.resize(newWidth,newHeight);

        if(resizedProcessor == null){
            System.out.println("Image can not be resized.");
            return;
        }

        image.setProcessor(resizedProcessor);


        image.updateAndDraw();
    }
}
