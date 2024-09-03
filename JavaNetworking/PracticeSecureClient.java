import java.io.*;
import javax.net.ssl.*;
import java.security.KeyStore;


public class PracticeSecureClient {
    public static void main(String[] args) {

        try{
            KeyStore trustStore = KeyStore.getInstance("JKS");

            trustStore.load(new FileInputStream("truststore.jks"),"password".toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");

            trustManagerFactory.init(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            SSLSocketFactory serverFactory = sslContext.getSocketFactory();

            SSLSocket socket = (SSLSocket) serverFactory.createSocket("localhost",12345);

            try(BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                String userInput;

                while((userInput = consoleInput.readLine()) != null){
                    out.println(userInput);
                    String serverResponse = in.readLine();
                    System.out.println("Server Response: " + serverResponse);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }



    }
}


/*

 *
 * create keystore.jks
 *  
 * keytool -genkeypair -alias mykey -keyalg RSA -keysize 2048 -keystore keystore.jks -validity 365
 * 
 * -alias mykey: this is an alias for your key entry
 * -keyalg RSA: the algorithm to use RSA
 * 
 * -keysize 2048: key size in bits
 * -keystore keystore.jks: the name of the keystore file
 * -validity 365: the validiity of the certificate in days
 * 
 * export the certification from keystore.jks
 * 
 * keytool -exportcert -alias mykey -file mykey.cer -keytstore keystore.jks
 * 
 * -alias mykey: the alias for key entry
 * -file mykey.cer: the file to which the certificate will be exported.
 * 
 * -keystore keystore.jks: the keystore from which to export the certification
 * 
 * create truststore.jks
 * 
 * keytool -importcert -alias mykey -file mykey.cer -keystore truststore.jks
 * 
 * 
 * varify the keystore and truststore:
 * 
 * list keystore entries
 * keytool -list -v -keystore keystore.jks
 * list truststore entries
 * keytool -list -v -keystore truststore.jks
 * 
 * 
 * 
 */
