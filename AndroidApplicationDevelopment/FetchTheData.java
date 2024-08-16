import java.net.URLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FetchTheData {
    public static void main(String[] args) {
        try{
            @SuppressWarnings("deprecation")
            URL url = new URL("https://www.javatpoint.com/");

            URLConnection connection = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
