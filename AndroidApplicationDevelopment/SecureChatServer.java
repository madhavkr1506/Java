import javax.net.ssl.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;



public class SecureChatServer extends Thread {

    private SSLSocket sslSocket;
    SecureChatServer(SSLSocket sslSocket){
        this.sslSocket = sslSocket;
    }

    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()))){
            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                if(inputLine.equalsIgnoreCase("Exit")){
                    System.out.println("Client requested to exit. Closing connection....");
                    sslSocket.close();
                    in.close();
                    break;
                    
                }
                System.out.println(inputLine);
            }
            
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(sslSocket != null && !sslSocket.isClosed()){
                    sslSocket.close();
                    System.out.println("Closing connection...");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        try{

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("keystore.jks"), "password".toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

            System.out.println("Server is listening to port 12345");
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                new SecureChatServer(sslSocket).start();


            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
