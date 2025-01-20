import java.net.URLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class FetchWeatherData {
    public static void main(String[] args) {
        try{

            String apiKey = "";
            String City = "Patna";
            String baseUrl = "https://api.openweathermap.org/data/2.5/weather?q=";

            @SuppressWarnings("deprecation")
            URL url = new URL(baseUrl + City + "&appid=" + apiKey);

            URLConnection connection = url.openConnection();

            String inpuString;
            StringBuilder responseString = new StringBuilder();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((inpuString = in.readLine()) != null) {
                responseString.append(inpuString);
            }

            in.close();

            JSONObject jsonObject = new JSONObject(responseString.toString());
            
            double temperature = jsonObject.getJSONObject("main").getDouble("temp");
            System.out.println("Weather in " + City + ": " + temperature + "K");



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


/*
 * this is how you compile this code 
 * 
 * PS C:\Users\madha\Java Programming\AndroidApplicationDevelopment\src> cd "C:\Users\madha\Java Programming\AndroidApplicationDevelopment\src"
>> 
PS C:\Users\madha\Java Programming\AndroidApplicationDevelopment\src> javac -cp ".;..\lib\json-20210307.jar" -d ..\bin FetchWeatherData.java
>> java -cp ".;..\lib\json-20210307.jar" FetchWeatherData
>>
 */