package ImageJ;
import ij.IJ;
import ij.ImagePlus;

public class ImagejExample1 {
    public static void main(String[] args) {
        ImagePlus image = IJ.openImage("C:\\\\Users\\\\madha\\\\Pictures\\\\portrait-man-cartoon-style.jpg");
        image.show();
    }
}
