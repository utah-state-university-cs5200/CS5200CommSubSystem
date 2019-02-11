package com.hw2.response;

import com.hw2.message;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class ProductFromInterest extends message {
    short msgType;
    @Override
    public Map decode(ByteBuffer bytes) {
        return null;
    }

    @Override
    public ByteBuffer encode() throws IOException {
        return null;
    }
}
