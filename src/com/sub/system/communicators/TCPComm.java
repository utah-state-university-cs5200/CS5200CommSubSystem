package com.sub.system.communicators;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

public class TCPComm extends Envelope<byte[]>{

    private Socket socket;

    TCPComm(Socket socket) {
        super(messageBytes, sourceSocketAddress);
        if(socket == null || !socket.isConnected()) {
            throw new IllegalArgumentException();
        }
        this.socket = socket;
    }

    public void send(byte[] messageBytes) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(messageBytes);
    }

    @Override
    public Envelope<byte[]> receive() throws IOException {
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[5096];
        int numBytesReadIntoBuffer = inputStream.read(buffer);

        byte[] messageBytes = Arrays.copyOf(buffer, numBytesReadIntoBuffer);
        InetSocketAddress sourceSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();

        return new Envelope<>(messageBytes, sourceSocketAddress);
    }
}
