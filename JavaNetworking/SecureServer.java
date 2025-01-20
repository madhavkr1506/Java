import java.io.*;
import java.security.KeyStore;
import javax.net.ssl.*;



public class SecureServer {

    public static void main(String[] args) {
        try{
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("keystore.jks"),"password".toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();

            SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(12345);

            System.out.println("Secure server is listening on port 12345");

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
                out.println("Echo: " + message);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


/*
 * 
 * security through encryption and secure sockets(SSL/TLS)
 * 
 * 1. basic of encryption : 
 * symmetric encryption: uses the same key for both encryption and decryption.
 * asymmetric encryption : uses a pair of keys(public and private).
 * 
 * 2. introduction to SSL/TLS : 
 * SSL = (secure sockets layer) an older protocol for securing communication.
 * TLS = (transport layer security) a more secure and updated protocol that replaced SSL.
 * 
 * implementing SSL/TLS in java:
 * JSSE(java secure socket extension) : provide classes for secure communication.
 * 
 * example : secure client-server communication
 * setting up a keystore and truststore
 * creating a secure server
 * creating a secure client
 * 
 * Note: A common algorithm for symmetric encryption is AES(Advance encryption standard).
 * 
 * A common algorithm for asymmetric encryption is RSA(Rivest-shamir-adleman)
 * 
 * 
 */