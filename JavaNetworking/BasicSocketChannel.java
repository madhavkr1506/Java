/*
 * java.nio : this package is used or designed to provide a more scalable and efficient  approach to io operations.
 * 
 * buffers: buffers are container for data. it is used to read from or write to channels.
 * common type includes: ByteBuffer, CharBuffer, and IntBuffer.
 * 
 * channels: it is similar to stream but can be non blocking.
 * key classes are: FileChannel, SocketChannel, and ServerSocketChannel.
 * 
 * Selectors: it allows multiplex multiple channels means we can manage multiple io using single thread.
 * 
 * use selector with selectableChannel to check which channels are ready for reading ao writing.
 */

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
public class BasicSocketChannel {

    public static void main(String[] args) {
        try{
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost",5000));
            String message = "Hello Madhav Kumar";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            socketChannel.write(buffer);

            socketChannel.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}