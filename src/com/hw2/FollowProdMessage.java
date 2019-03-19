package com.hw2;

import java.io.IOException;

public class FollowProdMessage extends Message{

    private String prodId;

    public FollowProdMessage(String prodId){
        this.prodId=prodId;
    }

    public static Message decode(byte[] messageBytes) {
        Message.Decoder decoder = new Message.Decoder(messageBytes);

        if (decoder.decodeMessageType() != Message.MessageType.FollowProd) {
            throw new IllegalArgumentException();
        }

        String prodId = decoder.decodeString();


        return new FollowProdMessage(prodId);
    }

    @Override
    public byte[] encode() throws IOException {
        return new Encoder()
                .encodeString(prodId)
                .toByteArray();
    }
}
