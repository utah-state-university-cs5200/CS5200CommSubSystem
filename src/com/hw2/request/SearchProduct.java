package com.hw2.request;

import com.hw2.message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class SearchProduct extends message {
    private String query;
    private Short msgType;
    private int userId;
    @Override
    public Map decode(ByteBuffer bytes) {
        return null;
    }

    @Override
    public ByteBuffer encode() throws IOException {
        SearchProduct sp = new SearchProduct();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        sp.encodeInt(userId);
        sp.encodeInt(msgType);
        sp.encodeString(query);
        return ByteBuffer.wrap(outputStream.toByteArray());
    }
}
