import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.*;

public class StockInfoInHTML {
    public static void main(String[] args) {
     try{
        @SuppressWarnings("deprecation")
        URL url = new URL("https://api.polygon.io/v2/aggs/ticker/TCS/range/1/day/2023-01-09/2023-01-09?apiKey=Pj2sScjXDkRmxrVTEQNMKZv8xpDw2C8J");

        URLConnection connection = url.openConnection();

        String inputLine;
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder reponse = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            reponse.append(inputLine);
        }

        JSONObject reponsObject = new JSONObject(reponse.toString());

        // System.out.println(reponsObject);

        System.out.println("Opening Price: " + reponsObject.getJSONArray("results").getJSONObject(0).getDouble("o"));
     }catch(Exception e){
        e.printStackTrace();
     } 
    }
}
