package com.hw2.common;

import com.hw2.message;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class CommonError extends message {
    short msgType;
    String errorMsg;
    @Override
    public Map decode(ByteBuffer bytes) {
        return null;
    }

    @Override
    public ByteBuffer encode() throws IOException {
        return null;
    }
}
