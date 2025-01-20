import java.io.*;
import javax.net.ssl.*;
import java.security.KeyStore;

public class chatServer extends Thread{

    private SSLSocket socket;

    public chatServer(SSLSocket socket){
        this.socket = socket;
    }

    public void startchat(){
        new Thread(new ServerReceiver(socket)).start();
        new Thread(new ServerSender(socket)).start();
    }
    public static void main(String[] args) {
        try{

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("keystore.jks"), "password".toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            SSLServerSocket sslServerSocket = (SSLServerSocket) sslContext.getServerSocketFactory().createServerSocket(12345);

            System.out.println("Server is listening to the port 12345");

            while (true) {
                SSLSocket socket = (SSLSocket) sslServerSocket.accept();
                new chatServer(socket).startchat();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class ServerSender implements Runnable{
    private SSLSocket socket;
    public ServerSender(SSLSocket socket){
        this.socket = socket;
    }

    public void run(){
        try(BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true)){


            String userInput;

            while((userInput = consoleInput.readLine()) != null){
                out.println(userInput);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


class ServerReceiver implements Runnable{

    private SSLSocket socket;
    public ServerReceiver(SSLSocket socket){
        this.socket = socket;
    }
    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            String message;
            while((message = in.readLine()) != null){
                System.out.println("Client: " + message);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}