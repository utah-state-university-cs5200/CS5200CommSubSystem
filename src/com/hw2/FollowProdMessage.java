package com.hw2;

import java.io.IOException;

public class FollowProdMessage extends message{

    private String prodId;

    public FollowProdMessage(String prodId){
        this.prodId=prodId;
    }

    public static message decode(byte[] messageBytes) {
        message.Decoder decoder = new message.Decoder(messageBytes);

        if (decoder.decodeMessageType() != message.MessageType.FollowProd) {
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
