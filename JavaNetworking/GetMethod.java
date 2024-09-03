import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetMethod {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{

            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder responseString = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    responseString.append(inputLine);
                }
                in.close();

                System.out.println("Response String: " + responseString);
            }
            else{
                System.out.println("GET request failed");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
