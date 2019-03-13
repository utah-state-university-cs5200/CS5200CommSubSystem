package com.hw2;

import java.io.IOException;

public class RateProdMessage extends message{

    private String prodId;
    private Short rating;

    public RateProdMessage(String prodId, Short rating){
        this.prodId=prodId;
        this.rating=rating;

    }

    public static message decode(byte[] messageBytes) {
        message.Decoder decoder = new message.Decoder(messageBytes);

        if (decoder.decodeMessageType() != MessageType.RateProd) {
            throw new IllegalArgumentException();
        }

        String prodId = decoder.decodeString();
        Short rating = decoder.decodeShort();

        return new RateProdMessage(prodId, rating);
    }

    @Override
    public byte[] encode() throws IOException {
        return new Encoder()
                .encodeString(prodId)
                .encodeShort(rating)
                .toByteArray();
    }
}
