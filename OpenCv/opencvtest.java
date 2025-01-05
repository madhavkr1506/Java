import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

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

        JFrame frame = new JFrame("Buffered Image");
        ImageIcon icon = new ImageIcon(convertIntoBufferedImage(imagecontainer));
        Image imageicon = icon.getImage().getScaledInstance(500,700,Image.SCALE_SMOOTH);
        frame.getContentPane().add(new JLabel(new ImageIcon(imageicon)));
        frame.setSize(500,700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static BufferedImage convertIntoBufferedImage(Mat mat){
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if(mat.channels() > 1){
            type = BufferedImage.TYPE_3BYTE_BGR;

        } 
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);

        byte[] targetpixel = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();

        mat.get(0,0,targetpixel);
        return image;
    }
}