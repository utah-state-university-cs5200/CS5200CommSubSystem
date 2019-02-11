package com.hw2.response;

import com.hw2.message;
import com.hw2.request.RegisterUser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public class UserRegistered extends message {
    short msgType;
    RegisterUser regUser;
    ProductFromInterest POI;
    private ByteArrayOutputStream outputStream;

    @Override
    public Map decode(ByteBuffer bytes) {
        bytes.order(ByteOrder.BIG_ENDIAN);
        Short msgType = decodeShort(bytes);
        HashMap res = new HashMap();
        if (msgType==21) {

            return res;
        }else {


            return res;
        }
    }

    @Override
    public ByteBuffer encode() throws IOException {
        return null;
    }
}
