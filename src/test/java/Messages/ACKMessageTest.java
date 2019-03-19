package test.java.Messages;

import com.hw2.ACKMessage;
import com.hw2.Message;
import static org.junit.Assert.*;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class ACKMessageTest {


    @org.junit.Test
    public void encodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.ACKMessage;
        byte[] expectedMessageBytes = new Message.Encoder().encodeMessageType(expectedMessageType).toByteArray();
        byte[] actualMessageBytes = new ACKMessage().encode();
        assertArrayEquals(expectedMessageBytes, actualMessageBytes);
    }

    @org.junit.Test
    public void decodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.ACKMessage;
        byte[] messageBytes = new Message.Encoder().encodeMessageType(expectedMessageType).toByteArray();
        ACKMessage received = ACKMessage.decode(messageBytes);
        assertEquals(received.getMessageType(), expectedMessageType);
    }
}
