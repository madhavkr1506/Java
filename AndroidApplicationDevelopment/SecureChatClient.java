import javax.net.ssl.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;



public class SecureChatClient {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        try{
            KeyStore truStore = KeyStore.getInstance("JKS");
            truStore.load(new FileInputStream("truststore.jks"), "password".toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(truStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost",12345);
            
            System.out.println("Server is connected for communication");

            try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(),true)){
                String inputLine;
                while (((inputLine = in.readLine()) != null)) {

                    if(inputLine.equalsIgnoreCase("Exit")){
                        out.println(inputLine);
                        break;
                    }
                    out.println(inputLine);

                    
                    
                }
            }finally{
                if(sslSocket != null || !sslSocket.isClosed()){
                    sslSocket.close();
                    System.out.println("Client connection closed...");
                }
            }



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
