
import java.security.KeyStore;
import java.io.*;
import javax.net.ssl.*;

public class SecureServerque1 extends Thread{

    private SSLSocket socket;
    public SecureServerque1(SSLSocket socket){
        this.socket = socket;
    }

    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true)){

            String message;
            while((message = in.readLine()) != null){
                System.out.println("Received : " + message);
                out.println("Echo: " + message);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try{

            KeyStore keyStore = java.security.KeyStore.getInstance("JKS");

            keyStore.load(new FileInputStream("keystore.jks"),"password".toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");

            keyManagerFactory.init(keyStore, "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");

            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();

            SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(5000);

            System.out.println("Server is listening to the port 5000");
            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();

                new SecureServerque1(socket).start();
            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
