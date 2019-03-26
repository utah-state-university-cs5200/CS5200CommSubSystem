package com.sub.system.communicators;

import com.hw2.Message;

import java.net.InetSocketAddress;
import java.util.Objects;

public class Envelope<T> {
    private Message message;
    private InetSocketAddress inetSocketAddress;

    Envelope(Message message, InetSocketAddress inetSocketAddress) {
        this.message = message;
        this.inetSocketAddress = inetSocketAddress;
    }

    public Envelope() {

    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public InetSocketAddress getInetSocketAddress() {
        return inetSocketAddress;
    }

    public void setInetSocketAddress(InetSocketAddress inetSocketAddress) {
        this.inetSocketAddress = inetSocketAddress;
    }

    InetSocketAddress getSrcInetSocketAddress() {
        return inetSocketAddress;
    }

    public boolean isValidToSend(Message m, InetSocketAddress isa){
        return m != null && isa != null && !Objects.equals(isa.getAddress().toString(), "0.0.0.0") && isa.getPort() != 0;
    }
}

