import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket()){

            byte[] message = "I love you zhaou lusi".getBytes();
            
            DatagramPacket datagramPacket = new DatagramPacket(message, 0,message.length,InetAddress.getByName("localhost"),12345);
            socket.send(datagramPacket);

            System.out.println("Message Send Successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
