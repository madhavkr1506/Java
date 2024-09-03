import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.net.InetSocketAddress;

public class NonBlockingClientCode {

    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8080));
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            while (true) {
                selector.select(); 

                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isConnectable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        if (clientChannel.isConnectionPending()) {
                            clientChannel.finishConnect();
                            System.out.println("Connected to the server");
                            clientChannel.register(selector, SelectionKey.OP_WRITE);
                        }
                    }
                    if (key.isWritable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(256);
                        buffer.put("Hello Server".getBytes());
                        buffer.flip();
                        while (buffer.hasRemaining()) {
                            clientChannel.write(buffer);
                        }
                        clientChannel.register(selector, SelectionKey.OP_READ);
                    }
                    if (key.isReadable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(256);
                        int readData = clientChannel.read(buffer);
                        if (readData > 0) {
                            buffer.flip();
                            byte[] data = new byte[buffer.remaining()];
                            buffer.get(data);
                            System.out.println("Received: " + new String(data));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
