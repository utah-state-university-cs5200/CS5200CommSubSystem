package com.hw2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Map;

public abstract class message {
    public abstract Map decode(ByteBuffer bytes);
    public abstract ByteBuffer encode() throws IOException;

    private ByteArrayOutputStream outputStream;

    public void encodeShort(short value) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putShort(value);
        outputStream.write(buffer.array());
    }

    public void encodeInt(int value) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(value);
        outputStream.write(buffer.array());
    }

    public void encodeString(String value) throws IOException {
        byte[] textBytes = value.getBytes(Charset.forName("UTF-16"));
        encodeShort((short) textBytes.length);
        outputStream.write(textBytes);
    }

    public static short decodeShort(ByteBuffer bytes) {
        return bytes.getShort();
    }

    public static String decodeString(ByteBuffer bytes) {
        short textLength = decodeShort(bytes);
        if (bytes.remaining() < textLength) {
            return null;
        }
        byte[] textBytes = new byte[textLength];
        bytes.get(textBytes, 0, textLength);
        return new String(textBytes, Charset.forName("UTF-16"));
    }
}
