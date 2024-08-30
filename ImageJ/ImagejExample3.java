package ImageJ;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;
public class ImagejExample3 {
    public static void main(String[] args) {
        ImagePlus image = IJ.openImage("C:\\Users\\madha\\Pictures\\portrait-man-cartoon-style.jpg");
        if(image == null){
            System.out.println("Failed to load the image.");
            return;
        }
        System.out.println("Original Height: " + image.getHeight());
        System.out.println("Original Width: " + image.getWidth());

        image.show();

        ImageProcessor processor = image.getProcessor();
        System.out.println("get color mode: " + processor.getColorModel());
        System.out.println("get background value: " + processor.getBackgroundValue());
        System.out.println("get bit value: " + processor.getBitDepth());
        System.out.println("get foreground value: " + processor.getForegroundValue());
        System.out.println("get statistics: " + processor.getStatistics());
        System.out.println("get auto threshold: " + processor.getAutoThreshold());
        System.out.println("get histogram max: " + processor.getHistogramMax());
        System.out.println("get histogram min: " + processor.getHistogramMin());
    }
}
