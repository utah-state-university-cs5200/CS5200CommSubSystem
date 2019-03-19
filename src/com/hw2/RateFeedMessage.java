package com.hw2;

import java.io.IOException;

public class RateFeedMessage extends Message{

    private String prodId;
    private Short vote;
    private String reviewId;
    private Short userId;

    public RateFeedMessage(String prodId,Short vote,String reviewId,Short userId){
        this.prodId=prodId;
        this.vote=vote;
        this.reviewId=reviewId;
        this.userId=userId;
    }

    public static Message decode(byte[] messageBytes) {
        Message.Decoder decoder = new Message.Decoder(messageBytes);

        if (decoder.decodeMessageType() != MessageType.RateFeed) {
            throw new IllegalArgumentException();
        }

        String prodId = decoder.decodeString();
        String reviewId = decoder.decodeString();
        Short userId = decoder.decodeShort();
        Short vote = decoder.decodeShort();

        return new RateFeedMessage(prodId,vote,reviewId,userId);
    }

    @Override
    public byte[] encode() throws IOException {
        return new Encoder()
                .encodeString(prodId)
                .encodeShort(vote)
                .encodeString(reviewId)
                .encodeShort(userId)
                .toByteArray();
    }
}
