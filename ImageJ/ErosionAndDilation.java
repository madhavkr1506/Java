package ImageJ;


import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;
public class ErosionAndDilation {
    public static void main(String[] args) {
        ImagePlus image = IJ.openImage("C:\\Users\\madha\\OneDrive\\Pictures\\Camera Roll 1\\MadhavDetails\\ProfilePic.jpg");
        if(image == null){
            System.out.println("Failed to load the image.");
            return;
        }

        ImageProcessor processor = image.getProcessor();

        processor.setAutoThreshold(ImageProcessor.ISODATA2,ImageProcessor.NO_LUT_UPDATE);

        processor.autoThreshold();

        // ImagePlus newImage = new ImagePlus("Threshold Image: ", processor);
        // newImage.show();

        processor.erode();
        ImagePlus erodedImage = new ImagePlus("Eroded Image: ",processor);
        erodedImage.show();

        processor = image.getProcessor();
        processor.setAutoThreshold(ImageProcessor.ISODATA2,ImageProcessor.NO_LUT_UPDATE);
        processor.autoThreshold();

        processor.dilate();
        ImagePlus dImagePlus = new ImagePlus("Dilated Image: ",processor);
        dImagePlus.show();


    }
}
