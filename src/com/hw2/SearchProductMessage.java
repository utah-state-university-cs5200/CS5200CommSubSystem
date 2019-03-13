package com.hw2;

import java.io.IOException;

public class SearchProductMessage extends message {

    private String prodName;

    public SearchProductMessage(String prodName){
        this.prodName=prodName;
    }

    public static message decode(byte[] messageBytes) {
        message.Decoder decoder = new message.Decoder(messageBytes);

        if (decoder.decodeMessageType() != MessageType.SearchProd) {
            throw new IllegalArgumentException();
        }

        String prodName = decoder.decodeString();

        return new SearchProductMessage(prodName);
    }

    @Override
    public byte[] encode() throws IOException {
        return new Encoder()
                .encodeString(prodName)
                .toByteArray();
    }
}
