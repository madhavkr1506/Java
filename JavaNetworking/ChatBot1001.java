import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
// import java.net.http.HttpResponse;

// import org.json.JSONArray;
// import org.json.JSONObject;

public class ChatBot1001 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        while (true) {
            try{
                URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=");

                System.out.print("Enter your question: ");
                String userInput = System.console().readLine();

                if("exit".equalsIgnoreCase(userInput)){
                    break;
                }

                String requestBody = "{\"contents\":[{\"parts\":[{\"text\":\"" + userInput + "\"}]}]}";

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                try(PrintWriter out = new PrintWriter(connection.getOutputStream(),true)){
                    out.write(requestBody);
                    
                }

                StringBuilder response = new StringBuilder();
                String inputLine;
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((inputLine = in.readLine()) != null) {
                    // response.append(inputLine);

                    System.out.println(inputLine);
                }

                // JSONObject jsonObject = new JSONObject(response.toString());

                // System.out.println(jsonObject);

                // JSONArray candidates = jsonObject.getJSONArray("candidates");
                // if (candidates.length() > 0) {
                //     JSONObject candidate = candidates.getJSONObject(0);
                //     JSONObject content = candidate.getJSONObject("content");
                //     JSONArray parts = content.getJSONArray("parts");
                //     if (parts.length() > 0) {
                //         JSONObject part = parts.getJSONObject(0);
                //         String text = part.getString("text");
                //         System.out.println("Response: " + text);
                //     }
                // }else{
                //     System.out.println("POST request not worked");
                // }





            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
