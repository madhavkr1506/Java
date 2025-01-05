import java.io.*;
import javax.net.ssl.*;
import java.security.KeyStore;


public class SecureClient {
    public static void main(String[] args) {
        try{
            KeyStore trustStore = KeyStore.getInstance("JKS");

            trustStore.load(new FileInputStream("truststore.jks"), "password".toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");

            trustManagerFactory.init(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            SSLSocket socket = (SSLSocket) socketFactory.createSocket("localhost",12345);

            try(BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                System.out.println("Connected to the secure server. Type your message:");

                String userInput;

                while ((userInput = consoleInput.readLine()) != null) {
                    out.println(userInput);
                    String serverRespoonse = in.readLine();
                    System.out.println("Server Response: " + serverRespoonse);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
