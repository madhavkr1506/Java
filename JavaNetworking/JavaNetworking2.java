/*
 * 
 * Url class represents a uniform resource locator, a pointer to a resource on world wide web. the UrlConnection class is used for communication with the resource pointed by url.
 * 
 * 
 */

import java.net.URL;
import java.net.URLConnection; 
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaNetworking2 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
