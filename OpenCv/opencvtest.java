import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class opencvtest {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
    }
    public static void main(String[] args) {
        String image = "C:\\Users\\madha\\Pictures\\3d-cartoon-style-character.jpg";
        Mat imagecontainer = Imgcodecs.imread(image);
        if(imagecontainer.empty()){
            System.out.println("Failed to load the image");
            
        }else{
            System.out.println("It is our success that we have loaded this image to our system memory.");
            System.out.println("Image size: " + imagecontainer.size());
        }
    }
}