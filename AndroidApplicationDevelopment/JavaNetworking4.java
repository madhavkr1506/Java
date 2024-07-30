/*
 * 
 * This example demostrate how to send an http get request to fetch data from a web service.
 * 
 * 
 */

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class JavaNetworking4 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            System.out.println("Response code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;

            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                
            }

            in.close();

            System.out.println("Response: " + response.toString());

            

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
