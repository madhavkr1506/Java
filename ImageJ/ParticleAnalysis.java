package ImageJ;

import ij.IJ;
import ij.ImagePlus;
import ij.measure.ResultsTable;
import ij.plugin.filter.ParticleAnalyzer;
import ij.process.ImageProcessor;

public class ParticleAnalysis {
    public static void main(String[] args) {
        ImagePlus image = IJ.openImage("C:\\Users\\madha\\OneDrive\\Pictures\\Camera Roll 1\\MadhavDetails\\ProfilePic.jpg");

        if(image == null){
            System.out.println("Failed to load image.");
            return;
        }

        ImageProcessor processor = image.getProcessor().convertToByte(true);

        int minthreshold = 128;
        int maxthreshold = 255;

        processor.setThreshold(minthreshold, maxthreshold, ImageProcessor.RED_LUT);
        image.setProcessor(processor);

        ResultsTable resultsTable = new ResultsTable();

        int options = ParticleAnalyzer.SHOW_OUTLINES | ParticleAnalyzer.INCLUDE_HOLES;

        int measurements = ParticleAnalyzer.AREA | ParticleAnalyzer.MEAN | ParticleAnalyzer.MIN_MAX | ParticleAnalyzer.CIRCULARITY;

        ParticleAnalyzer analyzer = new ParticleAnalyzer(options,measurements,resultsTable,100,Double.POSITIVE_INFINITY);

        analyzer.analyze(image);

        resultsTable.show("Particle Analysis Result");
        image.show();
    }
}
