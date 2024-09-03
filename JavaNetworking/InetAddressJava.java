import java.net.InetAddress;
import java.util.Scanner;


public class InetAddressJava {
    public static void main(String[] args) {
        try{
            
            @SuppressWarnings("resource")
            String hostname = new Scanner(System.in).nextLine();
            InetAddress getAnIpAddress = InetAddress.getByName(hostname);
            System.out.println("Ip Address of " + hostname + " is: " + getAnIpAddress.getHostAddress());

            

            // if you want to know about your pc

            InetAddress mypcAddress = InetAddress.getLocalHost();
            System.out.println("My pc Ip address: " + mypcAddress.getHostAddress());
            System.out.println("My pc name: " + mypcAddress.getHostName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
