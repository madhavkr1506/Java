import java.net.URL;
import java.net.HttpURLConnection;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaNetworking6 {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "applicaction/json; utf-8");

            connection.setRequestProperty("Accept", "application/json");

            connection.setDoOutput(true);

            String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 2}";

            try(OutputStream os = connection.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input,0,input.length);
            }

            int responseCode = connection.getResponseCode();

            System.out.println("Response code(POST): " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;

            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            System.out.println("Response : " + response.toString());

        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("GET Method");

        try{
            URL url2 = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();

            connection2.setRequestMethod("GET");

            System.out.println("Response code (GET): " + connection2.getResponseCode());

            String inputLine2;

            BufferedReader in2 = new BufferedReader(new InputStreamReader(connection2.getInputStream()));

            StringBuilder response2 = new StringBuilder();

            while ((inputLine2 = in2.readLine()) != null) {
                response2.append(inputLine2);
            }

            in2.close();

            System.out.println("Response: " + response2.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}