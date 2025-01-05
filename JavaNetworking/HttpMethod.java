// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
// import java.net.URI;
import java.net.URL;


public class HttpMethod {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // HttpClient client = HttpClient.newHttpClient();
        // int he above line we are creating instance of http client.

        // HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.w3schools.com/")).build();

        // in the above line we are creating a request object.



        // client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenAccept(response ->{
        //     System.out.println("Response Code: " + response.statusCode());
        //     System.out.println("Response Body: " + response.body());
        // }).join();

        // in the above line we are sending request and handling the response in string format.


        try{
            URL url = new URL("https://www.w3schools.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                System.out.println("ResponseCode : " + responseCode);
                String inputLine;
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
                in.close();
                connection.disconnect();
            }
            else{
                System.out.println("Connection failed: " + responseCode);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
