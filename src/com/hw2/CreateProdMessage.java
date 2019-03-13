package com.hw2;

import java.io.IOException;

public class CreateProdMessage extends message{

    private short userId;
    private String name;
    private String prodId;
    private short price;

    public CreateProdMessage(short userid, String name, String prodId, short price){
        this.userId=userid;
        this.name=name;
        this.prodId=prodId;
        this.price=price;

    }





    public static message decode(byte[] messageBytes) {
        Decoder decoder = new Decoder(messageBytes);

        if (decoder.decodeMessageType() != MessageType.CreateProd) {
            throw new IllegalArgumentException();
        }

        short userId = decoder.decodeShort();
        String name = decoder.decodeString();
        String prodId = decoder.decodeString();
        short price = decoder.decodeShort();

        return new CreateProdMessage(userId, name, prodId, price);
    }

    @Override
    public byte[] encode() throws IOException {
        return new Encoder()
                .encodeMessageType(messageType)
                .encodeShort(userId)
                .encodeString(name)
                .encodeString(prodId)
                .encodeShort(price)
                .toByteArray();

    }


}
