import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
// import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.*;
import java.awt.Image;
public class imageprocessing {

    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args) {
        String path = "C:\\Users\\madha\\Pictures\\portrait-man-cartoon-style.jpg";
        Mat image = Imgcodecs.imread(path);
        
        if(image == null){
            System.out.println("Failed to load the image.");
        }

        Mat grayscaleImage = new Mat(image.rows(),image.cols(),CvType.CV_8UC2);
        Imgproc.cvtColor(image, grayscaleImage, Imgproc.COLOR_RGB2GRAY);

        // Mat resizeMat = new Mat();
        // Size size = new Size(200,300);
        // Imgproc.resize(grayscaleImage, resizeMat, size);

        // Mat rotateMat = new Mat();
        // Core.rotate(grayscaleImage, rotateMat, Core.ROTATE_90_CLOCKWISE);

        Mat flipMat = new Mat();
        Core.flip(grayscaleImage, flipMat, 1);

        BufferedImage bufferedImage = convertintobufferedimage(flipMat);

        JFrame frame = new JFrame("Image processing");

        ImageIcon icon = new ImageIcon(bufferedImage);
        Image resizImage = icon.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);
        frame.setSize(500,700);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(new JLabel(new ImageIcon(resizImage)));
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
    }

    public static BufferedImage convertintobufferedimage(Mat mat){

        int type = BufferedImage.TYPE_BYTE_GRAY;
        if(mat.channels() > 1){
            type = BufferedImage.TYPE_3BYTE_BGR;
        }

        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        byte[] targetpixel = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
        mat.get(0,0,targetpixel);
        return image;
    }
}
