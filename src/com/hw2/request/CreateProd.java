package com.hw2.request;

import com.hw2.common.Product;
import com.hw2.message;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class CreateProd extends message {
    private short msgType;
    RegisterUser user;
    Product prod;

    @Override
    public Map decode(ByteBuffer bytes) {
        return null;
    }

    @Override
    public ByteBuffer encode() throws IOException {
        return null;
    }
}
