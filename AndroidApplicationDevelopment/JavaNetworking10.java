// UDP Client

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JavaNetworking10 {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket()){
            InetAddress address = InetAddress.getByName("localhost");
            byte[] sendData = "Hello, UDP Server".getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,address,9876);

            socket.send(sendPacket);

            System.out.println("Message sent to server.");


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
