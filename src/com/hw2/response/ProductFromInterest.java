package com.hw2.response;

import com.hw2.common.Product;
import com.hw2.message;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

public class ProductFromInterest extends message {
    short msgType;
    ArrayList <Product>prodList;

    @Override
    public Map decode(ByteBuffer bytes) {
        return null;
    }

    @Override
    public ByteBuffer encode() throws IOException {
        return null;
    }
}
