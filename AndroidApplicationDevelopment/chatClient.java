import java.io.*;
import javax.net.ssl.*;
import java.security.KeyStore;

public class chatClient extends Thread{
    public static void main(String[] args) {
        try{
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("truststore.jks"), "password".toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            SSLSocket socket = (SSLSocket) sslContext.getSocketFactory().createSocket("localhost",12345);

            System.out.println("Server is connected. Type your message.");

            new Thread(new ClientSender(socket)).start();
            new Thread(new ClientReceiver(socket)).start();

            

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


class ClientSender implements Runnable{
    private SSLSocket socket;
    public ClientSender(SSLSocket socket){
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


class ClientReceiver implements Runnable{
    private SSLSocket socket;

    public ClientReceiver(SSLSocket socket){
        this.socket = socket;

    }
    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            String message;
            while((message = in.readLine()) != null){
                System.out.println("Server: " + message);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}