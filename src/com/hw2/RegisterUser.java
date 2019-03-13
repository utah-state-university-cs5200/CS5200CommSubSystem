package com.hw2;

public  class RegisterUser {
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

    public static message decode(byte[] messageBytes) {
        return null;
    }
}
