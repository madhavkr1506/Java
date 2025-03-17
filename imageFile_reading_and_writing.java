import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;

public class imageFile_reading_and_writing {
    public static void main(String[] args) {
        try{
            File file = new File("D:\\Question\\50DaysCoding.png");
            FileInputStream inputStram = new FileInputStream(file);

            byte[] bytes = new byte[(int)file.length()];
            int number_of_bytes = inputStram.read(bytes);

            inputStram.close();


            System.out.println("Image file has been read. Total bytes: " + number_of_bytes);


            FileOutputStream outputStream = new FileOutputStream("D:\\Question\\output.png");
            outputStream.write(bytes);
            outputStream.close();

            System.out.println("Output has been created.");




        }catch(Exception e){
            e.printStackTrace();
        }catch(IOError e){
            e.printStackTrace();
        }
    }
}
