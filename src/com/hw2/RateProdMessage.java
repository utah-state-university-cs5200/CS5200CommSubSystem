package com.hw2;

import java.io.IOException;

public class RateProdMessage extends message{

    private String prodId;
    private Float rating;
    private String review;
//    review string will be the feedback of item by user

    public RateProdMessage(String prodId, Float rating, String review){
        this.prodId=prodId;
        this.rating=rating;
        this.review=review;

    }

    public static message decode(byte[] messageBytes) {
        message.Decoder decoder = new message.Decoder(messageBytes);

        if (decoder.decodeMessageType() != MessageType.RateProd) {
            throw new IllegalArgumentException();
        }

        String prodId = decoder.decodeString();
        String review = decoder.decodeString();
        Float rating = decoder.decodeFloat();

        return new RateProdMessage(prodId,rating,review);
    }

    @Override
    public byte[] encode() throws IOException {
        return new Encoder()
                .encodeString(prodId)
                .encodeFloat(rating)
                .encodeString(review)
                .toByteArray();
    }
}
