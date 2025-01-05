import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class AviationStack {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try{

            URL url = new URL("https://api.aviationstack.com/v1/flights?access_key=");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                StringBuilder responseString = new StringBuilder();
                String inputLine;
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((inputLine = in.readLine()) != null) {
                    responseString.append(inputLine);                    
                }
                in.close();

                JSONObject jsonObject = new JSONObject(responseString.toString());

                JSONArray jsonArray = jsonObject.getJSONArray("data");

                for(int i=0;i<jsonArray.length();i++){
                    JSONObject flight = jsonArray.getJSONObject(i);

                    String flight_date = flight.getString("flight_date");

                    String flight_status = flight.getString("flight_status");

                    JSONObject departure = flight.getJSONObject("departure");

                    String departureairport = departure.getString("airport");
                    String departuretimezone = departure.getString("timezone");
                    String departurescheduled = departure.getString("scheduled");
                    String departureestimated = departure.getString("estimated");

                    JSONObject arrival = flight.getJSONObject("arrival");
                    String arrivalAirport = arrival.getString("airport");
                    String arrivalTimezone = arrival.getString("timezone");
                    String arrivalScheduled = arrival.getString("scheduled");
                    String arrivalEstimated = arrival.getString("estimated");

                    JSONObject flightDetails = flight.getJSONObject("flight");
                    String icao24 = flightDetails.getString("icao");
                    


                    System.out.println("Aircraft ICAO24: " + icao24);
                    System.out.println("Departure Flight date: " + flight_date);
                    System.out.println("Departure Flight status: " + flight_status);
                    System.out.println("Departure Airport: " + departureairport);
                    System.out.println("Departure TimeZone: " + departuretimezone);
                    System.out.println("Departure Scheduled: " + departurescheduled);
                    System.out.println("Departure Estimated: " + departureestimated);

                    System.out.println("Arrival Airport: " + arrivalAirport);
                    System.out.println("Arrival TimeZone: " + arrivalTimezone);
                    System.out.println("Arrival Scheduled: " + arrivalScheduled);
                    System.out.println("Arrival Estimated: " + arrivalEstimated);

                    

                    System.out.println("--------------------------------------------");
                    System.out.println();

                }

                
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}