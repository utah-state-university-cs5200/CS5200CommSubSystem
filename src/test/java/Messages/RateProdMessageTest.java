package test.java.Messages;

import com.hw2.Message;
import com.hw2.RateProdMessage;

import java.io.IOException;

import static org.junit.Assert.*;

public class RateProdMessageTest {
    @org.junit.Test
    public void encodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.RateProd;
        String expectedProdId = "501";
        Float expectedRating = 4.5f;
        String expectedReview = "good Product";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeString(expectedProdId)
                .encodeFloat(expectedRating)
                .encodeString(expectedReview)
                .toByteArray();
        byte[] actualMessageBytes = new RateProdMessage(expectedProdId, expectedRating, expectedReview).encode();
        assertArrayEquals(expectedMessageBytes, actualMessageBytes);
    }

    @org.junit.Test
    public void decodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.RateProd;
        String expectedProdId = "501";
        Float expectedRating = 4.5f;
        String expectedReview = "good Product";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeString(expectedProdId)
                .encodeFloat(expectedRating)
                .encodeString(expectedReview)
                .toByteArray();
        RateProdMessage rateProdMessage = RateProdMessage.decode(expectedMessageBytes);
        assertEquals(expectedProdId, rateProdMessage.getProdId());
        assertEquals(expectedRating, rateProdMessage.getRating());
        assertEquals(expectedReview, rateProdMessage.getReview());
        assertEquals(expectedMessageType, rateProdMessage.getMessageType());
    }
}
