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

        

        ImageProcessor processor = image.getProcessor();
        System.out.println("get color mode: " + processor.getColorModel());
        System.out.println("get background value: " + processor.getBackgroundValue());
        System.out.println("get bit value: " + processor.getBitDepth());
        System.out.println("get foreground value: " + processor.getForegroundValue());
        System.out.println("get statistics: " + processor.getStatistics());
        System.out.println("get auto threshold: " + processor.getAutoThreshold());
        System.out.println("get histogram max: " + processor.getHistogramMax());
        System.out.println("get histogram min: " + processor.getHistogramMin());

        // processor.blurGaussian(2.0); //--> smooth an edge by reducing noise and details.
        // this is done by averaging the pixels with their neighbors.

        // ImagePlus blurredImage = new ImagePlus("Blurred Image",processor);

        // blurredImage.show();

        // processor.findEdges();
        // ImagePlus edgeDetection = new ImagePlus("Edge Detecction: ", processor);

        // edgeDetection.show();
        // edge detection is uded to find boundaries within images, which is useful in identifying objects or regions.

        processor.setAutoThreshold(ImageProcessor.ISODATA2, ImageProcessor.RED_LUT);

        processor.autoThreshold();
        ImagePlus thresholdImage = new ImagePlus("Threshold Image", processor);

        thresholdImage.show();

        // thresholding convert image into a binary image(black and white) based on pixel intensity threshold. this is particularly useful for  isolating objects in an image.

    }
}
