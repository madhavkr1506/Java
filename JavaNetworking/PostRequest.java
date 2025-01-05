import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;

public class PostRequest {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{

            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");

            connection.setDoOutput(true);

            
            String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            System.out.println("Response Code: " + connection.getResponseCode());

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String inputLine;
            StringBuilder responseString = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseString.append(inputLine);
            }

            in.close();

            System.out.println("Response String: " + responseString.toString());

        }catch(Exception e){
            e.printStackTrace();
        }    
    }
}