package com.sub.system.communicators;

import com.hw2.Message;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;

public class UDPComm implements Runnable{
    private DatagramChannel datagramChannel;

    public UDPComm(DatagramChannel datagramChannel, InetSocketAddress address) throws IOException{
        super();
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

    public void send(Envelope outgoingEnvelope) throws IOException {
        int port = 8080;
        byte [] messageBytes = outgoingEnvelope.getMessage().encode();
        InetSocketAddress address = outgoingEnvelope.getInetSocketAddress();
        datagramChannel.send(ByteBuffer.wrap(messageBytes), address);
    }

    public Envelope receive() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(5096);
        buffer.clear();
        InetSocketAddress sourceSocketAddress = (InetSocketAddress) datagramChannel.receive(buffer);

        byte[] messageBytes = Arrays.copyOf(buffer.array(), buffer.position());
        return new Envelope(Message.decode(messageBytes), sourceSocketAddress);
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

    @Override
    public void run() {

    }
}
