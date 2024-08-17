import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class ServerSideCoding {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(12345)){
            System.out.println("Server is coonnected");
            Socket socket = serverSocket.accept();

            new serverThread(socket).start();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class serverThread extends Thread{
    private Socket socket;

    serverThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true)){
            String inputLine;

            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
                out.println("Server echo: " + inputLine);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
