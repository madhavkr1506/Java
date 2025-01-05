
// ChatClient

import java.io.*;
import java.net.*;


public class JavaNetworking8 {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",12345);
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            String userInput;

            while ((userInput = consoleInput.readLine()) != null) {
                out.println(userInput);
                System.out.println("Server response: " + in.readLine());
                
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
