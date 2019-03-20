package com.sub.system.communicators;

import com.hw2.Message;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Envelope<T> {
    private T message;
    private InetSocketAddress inetSocketAddress;

    public Envelope(T message, InetSocketAddress inetSocketAddress) {
        this.message = message;
        this.inetSocketAddress = inetSocketAddress;
    }

    public Envelope() {
    }

    public T getMessage() {
        return message;
    }

    public InetSocketAddress getSrcInetSocketAddress() {
        return inetSocketAddress;
    }

    public Envelope<T> receive() throws IOException {
        return null;
    }

    public boolean isValidToSend(Message m, InetSocketAddress isa){
        if(m != null &&  isa != null && isa.getAddress().toString() !="0.0.0.0" && isa.getPort()!=0)
            return true;
        else
            return false;
    }
}

