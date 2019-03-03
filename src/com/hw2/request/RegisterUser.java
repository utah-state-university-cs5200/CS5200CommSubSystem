package com.hw2.request;

import com.hw2.message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public  class RegisterUser extends message {
    private short msgType;
    private int userId;
    private String Name;
    private String emailId;
    private String password;
    private String areaOfInterest;
    private String searchProd;

    public RegisterUser(short msgType, int userId, String Name, String emailId, String password, String areaOfInterest, String searchProd) {
        this.msgType = msgType;
        this.userId = userId;
        this.Name = Name;
        this.emailId = emailId;
        this.password = password;
        this.areaOfInterest = areaOfInterest;
        this.searchProd = searchProd;
    }

    public RegisterUser() {

    }

    @Override
    public Map decode(ByteBuffer bytes) {
        return null;
    }

    public ByteBuffer encode() throws IOException {
        RegisterUser enc = new RegisterUser();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        enc.encodeShort(msgType);
        enc.encodeInt(userId);
        enc.encodeString(Name);
        enc.encodeString(emailId);
        enc.encodeString(password);
        enc.encodeString(areaOfInterest);
        return ByteBuffer.wrap(outputStream.toByteArray());
    }
}
