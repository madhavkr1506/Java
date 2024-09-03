/*
 * 
 * This example demonstrate how to send an http post request to submit data to a web service.
 * 
 */


import java.net.URL; 
import java.net.HttpURLConnection;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaNetworking5 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type","application/json; utf-8");

            connection.setRequestProperty("Accept", "application/json");

            connection.setDoOutput(true);

            String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

            try(OutputStream os = connection.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input,0,input.length); 
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));

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
