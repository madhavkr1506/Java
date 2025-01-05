import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class AirVisual {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{

            URL url = new URL("http://api.airvisual.com/v2/city?city=Patna&state=Bihar&country=India&key=");
            URLConnection connection = url.openConnection();

            StringBuilder response = new StringBuilder();

            String inputLine;

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject jsonObject = new JSONObject(response.toString());
            System.out.println(jsonObject);

            System.out.println("Important Information: ");


            System.out.println("Humidity: " + jsonObject.getJSONObject("data").getJSONObject("current").getJSONObject("weather").getDouble("hu"));
            System.out.println();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
