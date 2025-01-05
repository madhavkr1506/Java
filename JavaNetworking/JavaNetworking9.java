/*
 * 
 * This example demonstrate basic UDP communication between a client and a server.
 * 
 * 
 * UDP Server
 */


 import java.net.DatagramPacket;
 import java.net.DatagramSocket;

public class JavaNetworking9 {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(9876)){

            byte[] receivedData = new byte[1024];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(receivedPacket);

                String message = new String(receivedPacket.getData(),0,receivedPacket.getLength());
                System.out.println("Received: " + message);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
