package ImageJ;

import ij.IJ;
import ij.ImagePlus;
import ij.gui.Roi;
import ij.measure.Measurements;
import ij.process.ImageProcessor;
import ij.process.ImageStatistics;

public class RegionOfIntrest {
    public static void main(String[] args) {
        ImagePlus image = IJ.openImage("C:\\Users\\madha\\OneDrive\\Pictures\\Camera Roll 1\\MadhavDetails\\ProfilePic.jpg");

        if(image == null){
            System.out.println("Failed to load the image.");
            return;
        }
        

        Roi roi = new Roi(120,50,200,200);
        image.setRoi(roi);
        image.show();

        ImageProcessor processor = image.getProcessor().crop();

        ImageStatistics stats = ImageStatistics.getStatistics(processor,Measurements.MEAN | Measurements.MIN_MAX,null);

        System.out.println("Mean pixel value in roi: " + stats.mean);
        System.out.println("Minimum pixel value in roi: " + stats.min);
        System.out.println("Maximum pixel value in roi: " + stats.max);

        processor.blurGaussian(5.0);
        ImagePlus processimage = new ImagePlus("Processed Roi",processor);

        processimage.show();


    }
}
