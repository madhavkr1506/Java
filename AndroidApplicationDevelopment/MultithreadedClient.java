import java.io.*;
import java.net.*;

public class MultithreadedClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to the server. Type your messages:");

            String userInput;
            while ((userInput = consoleInput.readLine()) != null) {
                out.println(userInput);
                String serverResponse = in.readLine();
                System.out.println("Server Response: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
