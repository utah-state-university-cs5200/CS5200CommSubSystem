package com.hw2;

import java.io.IOException;

public class LoginUserMessage extends Message{

    private String email;
    private String password;


    public LoginUserMessage(String email, String password){
        this.email=email;
        this.password=password;
    }

    public static Message decode(byte[] messageBytes) {
        Message.Decoder decoder = new Message.Decoder(messageBytes);

        if (decoder.decodeMessageType() != MessageType.LoginUser) {
            throw new IllegalArgumentException();
        }

        String email = decoder.decodeString();
        String password = decoder.decodeString();

        return new LoginUserMessage(email, password);
    }

    @Override
    public byte[] encode() throws IOException {
        return new Encoder()
                .encodeString(email)
                .encodeString(password)
                .toByteArray();
    }
}
