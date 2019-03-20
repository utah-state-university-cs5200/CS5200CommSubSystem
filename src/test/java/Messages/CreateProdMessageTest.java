package test.java.Messages;

import com.hw2.CreateProdMessage;
import com.hw2.Message;

import java.io.IOException;

import static org.junit.Assert.*;

public class CreateProdMessageTest {

    @org.junit.Test
    public void encodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.CreateProd;
        short expectedUserId = 1;
        String expectedName = "Iphone XS";
        String expectedProdId = "501";
        short expectedPrice = 900;
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeShort(expectedUserId)
                .encodeString(expectedName)
                .encodeString(expectedProdId)
                .encodeShort(expectedPrice)
                .toByteArray();
        byte[] actualMessageBytes = new CreateProdMessage(expectedUserId, expectedName, expectedProdId, expectedPrice).encode();
        assertArrayEquals(expectedMessageBytes, actualMessageBytes);
    }

    @org.junit.Test
    public void decodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.CreateProd;
        short expectedUserId = 1;
        String expectedName = "Iphone XS";
        String expectedProdId = "501";
        short expectedPrice = 900;
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeShort(expectedUserId)
                .encodeString(expectedName)
                .encodeString(expectedProdId)
                .encodeShort(expectedPrice)
                .toByteArray();
        CreateProdMessage createProdMessage = CreateProdMessage.decode(expectedMessageBytes);
        assertEquals(expectedUserId, createProdMessage.getUserId());
        assertEquals(expectedName, createProdMessage.getName());
        assertEquals(expectedPrice, createProdMessage.getPrice());
        assertEquals(expectedProdId, createProdMessage.getProdId());
        assertEquals(expectedMessageType, createProdMessage.getMessageType());
    }
}
