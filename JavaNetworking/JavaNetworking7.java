/*
 * 
 * This example demonstrates a simple chat application using Java Sockets. There will be a server and a client.
 * 
 */
// ChatServer

import java.io.*;
import java.net.*;

public class JavaNetworking7 {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(12345)){
            System.out.println("Server is listening on port 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New Client Connected");

                new ServerThread(socket).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}

class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true)){

            String message;
            while((message = in.readLine()) != null){
                System.out.println("Received: " + message);
                out.println("Echo: " + message);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
