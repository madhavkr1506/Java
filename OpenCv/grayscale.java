import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.*;
import java.awt.*;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;



public class grayscale {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args) {
        String path = "C:\\Users\\madha\\Pictures\\portrait-man-cartoon-style.jpg";

        Mat image = Imgcodecs.imread(path);
        Mat grayImage = new Mat(image.rows(),image.cols(),CvType.CV_8UC1);
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        if(image.empty()){
            System.out.println("Failed to load the image.");
        }
        else{
            System.out.println("We have uploaded the image in pc memory");
            System.out.println("Image size: " + image.size());
        }

        JFrame frame = new JFrame("Blurred Image");
        ImageIcon icon = new ImageIcon(convertintoBufferedImage(grayImage));
        Image resizImage = icon.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);

        frame.getContentPane().add(new JLabel(new ImageIcon(resizImage)));
        frame.pack();

        frame.setSize(500,700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        

    }

    public static BufferedImage convertintoBufferedImage(Mat mat){
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

