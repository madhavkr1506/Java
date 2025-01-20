import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {

        try(DatagramSocket socket = new DatagramSocket(12345)){
            byte[] message = new byte[1024];
            
            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(message, message.length);
                socket.receive(datagramPacket);

                String receivedMessage = new String(datagramPacket.getData(),0,datagramPacket.getLength());

                System.out.println(receivedMessage);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
