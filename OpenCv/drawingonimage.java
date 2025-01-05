import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.Image;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import javax.swing.*;



public class drawingonimage {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args) {
        String path = "C:\\Users\\madha\\Pictures\\3d-cartoon-style-character.jpg";

        Mat image = Imgcodecs.imread(path);
        // Imgproc.rectangle(image, new Point(150,150), new Point(250,250), new Scalar(0,255,0),30);
        // Imgproc.circle(image, new Point(300,300), 100, new Scalar(0,255,0),50);

        // Imgproc.line(image, new Point(150,150), new Point(300,300), new Scalar(255,255,255),60);

        // Imgproc.putText(image, "Hello Madhav", new Point(200,500), Imgproc.FONT_HERSHEY_SCRIPT_COMPLEX, 20.5, new Scalar(0,255,0),5);


        if(image.empty()){
            System.out.println("Failed to load image.");
        }

        // Mat rgbMat = new Mat();
        // Imgproc.cvtColor(image, rgbMat, Imgproc.COLOR_BGR2RGB);

        // Mat thresholdMat = new Mat();
        // Imgproc.threshold(image, thresholdMat, 125, 255, Imgproc.THRESH_BINARY);

        // Mat bilateralblur = new Mat();
        // Imgproc.bilateralFilter(image, bilateralblur, 50, 50, 80);


        Mat gaussianMat = new Mat();
        Imgproc.GaussianBlur(image, gaussianMat, new Size(15,15), 0);

        BufferedImage bufferedImage = convertintobuffer(gaussianMat);

        
        
        prepareGui(bufferedImage);
        
    }

    public static BufferedImage convertintobuffer(Mat mat){
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if(mat.channels() > 1){
            type = BufferedImage.TYPE_3BYTE_BGR;
        }

        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        byte[] targetpixel = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        mat.get(0,0,targetpixel);
        return image;
    }

    public static void prepareGui(BufferedImage bufferedImage){
        JFrame frame = new JFrame("ReadWriteOnImage");
        ImageIcon icon = new ImageIcon(bufferedImage);
        Image resizeicon = icon.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);

        frame.setSize(600,600);
        frame.getContentPane().add(new JLabel(new ImageIcon(resizeicon)));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
