import java.io.*;
import javax.net.ssl.*;
import java.security.KeyStore;


public class PracticeSecureServer{
    
    public static void main(String[] args) {
        try{
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("keystore.jks"), "password".toCharArray());
            
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();

            SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(12345);

            System.out.println("Secure server is listening to the port 12345");

            while (true) {

                SSLSocket socket = (SSLSocket) serverSocket.accept();

                new SecureServerThread(socket).start();
            }

            

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}



class SecureServerThread extends Thread{
    private SSLSocket socket;
    public SecureServerThread(SSLSocket socket){
        this.socket = socket;
    }

    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true)){

            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Echo:" + message);

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
