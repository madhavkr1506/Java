import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClient {

    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key="; 

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        while (true) {
            try {
                System.out.print("Enter your question: ");
                String userInput = System.console().readLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                String requestBody = "{\"contents\":[{\"parts\":[{\"text\":\"" + userInput + "\"}]}]}";

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(API_URL))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String responseBody = response.body();
                JSONObject jsonResponse = new JSONObject(responseBody);
                
                JSONArray candidates = jsonResponse.getJSONArray("candidates");
                if (candidates.length() > 0) {
                    JSONObject candidate = candidates.getJSONObject(0);
                    JSONObject content = candidate.getJSONObject("content");
                    JSONArray parts = content.getJSONArray("parts");
                    if (parts.length() > 0) {
                        JSONObject part = parts.getJSONObject(0);
                        String text = part.getString("text");
                        System.out.println("Response: " + text);
                    }
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
