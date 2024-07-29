import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class JavaNetworking3 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{
            String apikey = "1abda653c4c413b0f3be7e69d5ce7e12";
            String city = "Patna";
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="+apikey);
            URLConnection connection = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();

            JSONObject jasonresponse = new JSONObject(response.toString());

            System.out.println("Weather in " + city + ": " + jasonresponse.getJSONObject("main").getDouble("temp") + "K");
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
