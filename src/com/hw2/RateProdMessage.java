package com.hw2;

public class RateProdMessage {
    private short msgType;
    ProductMessage prod;
    RegisterUserMessage user;
    Float rating;

    public static message decode(byte[] messageBytes) {
        return null;
    }
}
