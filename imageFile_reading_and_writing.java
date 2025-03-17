import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class imageFile_reading_and_writing {
    private static Logger LOGGER = Logger.getLogger(imageFile_reading_and_writing.class.getName());
    public static void main(String[] args) {
        LOGGER.log(Level.INFO,"Reading and Writing into a file.");
        try{
            File file = new File("D:\\Question\\50DaysCoding.png");
            FileInputStream inputStram = new FileInputStream(file);

            byte[] bytes = new byte[(int)file.length()];
            int number_of_bytes = inputStram.read(bytes);

            inputStram.close();

            LOGGER.log(Level.INFO, "Image file has been read till " + number_of_bytes + " bytes");

            FileOutputStream outputStream = new FileOutputStream("D:\\Question\\output.png");
            outputStream.write(bytes);
            outputStream.close();

            LOGGER.log(Level.INFO, "Image file has been written till " + number_of_bytes + " bytes");

        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "An error has been occured while reading and writing in a file");
        }
    }
}
