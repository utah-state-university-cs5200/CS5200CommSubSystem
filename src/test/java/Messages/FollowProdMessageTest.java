package test.java.Messages;

import com.hw2.FollowProdMessage;
import com.hw2.Message;
import org.junit.After;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
public class FollowProdMessageTest {

    @After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void encodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.FollowProd;
        String expectedProdId = "501";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeString(expectedProdId)
                .toByteArray();
        byte[] actualMessageBytes = new FollowProdMessage(expectedProdId).encode();
        assertArrayEquals(expectedMessageBytes, actualMessageBytes);
    }

    @org.junit.Test
    public void decodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.FollowProd;
        String expectedProdId = "501";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeString(expectedProdId)
                .toByteArray();
        FollowProdMessage followProdMessage = FollowProdMessage.decode(expectedMessageBytes);
        assertEquals(expectedProdId, followProdMessage.getProdId());
        assertEquals(expectedMessageType, followProdMessage.getMessageType());
    }
}
