package com.hw2;

import java.io.IOException;

public  class RegisterUserMessage extends message {
    private short userId;
    private String Name;
    private String emailId;
    private String password;
    private String areaOfInterest;

    public RegisterUserMessage(short userId, String Name, String emailId, String password, String areaOfInterest) {
        super(MessageType.RegisterUser);
        this.userId = userId;
        this.Name = Name;
        this.emailId = emailId;
        this.password = password;
        this.areaOfInterest = areaOfInterest;
    }


    public static RegisterUserMessage decode(byte[] messageBytes) {
        Decoder decoder = new Decoder(messageBytes);

        if (decoder.decodeMessageType() != MessageType.RegisterUser) {
            throw new IllegalArgumentException();
        }

        short userId = decoder.decodeShort();
        String Name = decoder.decodeString();
        String emailId = decoder.decodeString();
        String password = decoder.decodeString();
        String areaOfInterest = decoder.decodeString();

        return new RegisterUserMessage(userId, Name, emailId, password, areaOfInterest);
    }

    @Override
    public byte[] encode() throws IOException {
        return new Encoder()
                .encodeMessageType(messageType)
                .encodeShort(userId)
                .encodeString(Name)
                .encodeString(emailId)
                .encodeString(password)
                .encodeString(areaOfInterest)
                .toByteArray();
    }
}
