package test.java.Messages;


import com.hw2.ACKMessage;
import com.hw2.Message;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class RateFeedMessageTest {

    @org.junit.Test
    public void encodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.RateFeed;
        byte[] expectedMessageBytes = new Message.Encoder().encodeMessageType(expectedMessageType).toByteArray();
        byte[] actualMessageBytes = new ACKMessage().encode();
        assertArrayEquals(expectedMessageBytes, actualMessageBytes);
    }

    @org.junit.Test
    public void decodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.RateFeed;
        byte[] messageBytes = new Message.Encoder().encodeMessageType(expectedMessageType).toByteArray();
        ACKMessage received = ACKMessage.decode(messageBytes);
        assertEquals(received.getMessageType(), expectedMessageType);
    }
}
