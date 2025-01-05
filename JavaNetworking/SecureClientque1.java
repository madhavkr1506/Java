import java.io.*;
import java.security.KeyStore;
import javax.net.ssl.*;

public class SecureClientque1 {
    public static void main(String[] args) {
        try{
            KeyStore trustStore = KeyStore.getInstance("JKS");

            trustStore.load(new FileInputStream("truststore.jks"),"password".toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");

            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);


            SSLSocket socket = (SSLSocket) sslContext.getSocketFactory().createSocket("localhost",5000);


            try(BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                System.out.println("Server is ready to response. Please type your message.");
                
                String userInput;

                while((userInput = consoleInput.readLine()) != null){
                    out.println(userInput);

                    String serverResponse = in.readLine();
                    System.out.println("ServerResponse: " + serverResponse);
                }
            }




        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
