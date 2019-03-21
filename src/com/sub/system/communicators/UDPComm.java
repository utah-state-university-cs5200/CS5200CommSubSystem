package com.sub.system.communicators;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.ByteBuffer;
import java.net.InetAddress;
import java.util.Arrays;
public class UDPComm extends Envelope<byte[]>{
    private DatagramChannel datagramChannel;

    public UDPComm(DatagramChannel datagramChannel, InetSocketAddress address) throws IOException{
        this.datagramChannel = datagramChannel;
        if (address.getPort() != 0)
            this.datagramChannel.bind(address);
        else
            this.datagramChannel.bind(null);
    }

    public void start() throws IOException {
        datagramChannel = DatagramChannel.open();
        datagramChannel.bind(null);
    }

    public void send(byte[] messageBytes, InetAddress address, int port) throws IOException {
        datagramChannel.send(ByteBuffer.wrap(messageBytes), new InetSocketAddress(address, port));
    }

    public Envelope<byte[]> receive() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(5096);
        buffer.clear();
        InetSocketAddress sourceSocketAddress = (InetSocketAddress) datagramChannel.receive(buffer);

        byte[] messageBytes = Arrays.copyOf(buffer.array(), buffer.position());

        return new Envelope<>(messageBytes, sourceSocketAddress);
    }

    public void stop() throws IOException {
        datagramChannel.close();
    }

    public void readAndWrite() throws IOException {
        String newData = "New String to write to file..."
                + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(5048);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        datagramChannel.connect(new InetSocketAddress("test", 80));
        int bytesRead = datagramChannel.read(buf);
        int bytesWritten = datagramChannel.write(buf);
    }
}
