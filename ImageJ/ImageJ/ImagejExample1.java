package ImageJ;
import ij.IJ;
import ij.ImagePlus;

public class ImagejExample1 {
    public static void main(String[] args) {
        ImagePlus image = IJ.openImage("C:\\Users\\madha\\OneDrive\\Pictures\\Camera Roll 1\\MadhavDetails\\ProfilePic.jpg");
        image.show();
    }
}
