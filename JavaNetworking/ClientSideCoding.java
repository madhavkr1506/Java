import java.net.Socket;
import java.io.*;


public class ClientSideCoding {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",12345);
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            System.out.println("Connected to the server");
            String inputLine;
            while ((inputLine = consoleInput.readLine()) != null) {
                output.println(inputLine);
                System.out.println(in.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
