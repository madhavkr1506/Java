/*
 * 
 * Networking in java involves communication between two or more computers over a network. java provides a robust set of classes and methods for network communication in java.net package.
 * 
 * 1. Basic of networking : 
 * ip address and ports : Aunique string of number separated by periods that identifies each computer using the internet protocol to communicate iver a network.
 * and port : A number Assigned to specific network services on a host . for example http uses port 80, https uses port 443.
 * 
 * 
 * protocols(TCP and UDP); : TCP : Connection oriented protocol. UDP : Connectionless Protocol
 * 
 * 
 * 2.java networking basic : 
 * InetAddress class : represent an IP address. It has method to work with IP addresses.
 * 
 * URL and URLConnections classes
 * 
 * 3. Socket Programming
 * TCP sockets
 * socket class
 * serversocket class
 * 
 * UDP sockets
 * DatagramSocket class
 * DatagramPacket class
 * 
 * 4. Client - Server application
 * 
 * Simple echo server and client
 * Multithreaded server
 * 
 * 5.Advance networking
 * Non-blocking I/O with java.nio
 * Secure Sockets (SSL/TLS)
 * 
 */


import java.net.InetAddress;
public class JavaNetworking1 {
    public static void main(String[] args) {
        try{

            // get the IP address of a hostname :
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("IP Address: " + address.getHostAddress());

            // get the hostname of an IP address :

            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local IP address : " + localAddress.getHostAddress());
            System.out.println("Hostname: " + localAddress.getHostName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
