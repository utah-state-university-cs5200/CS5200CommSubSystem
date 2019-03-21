package test.java.Messages;

import com.hw2.Message;
import com.hw2.SearchProductMessage;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
public class SearchProductMessageTest {

    @org.junit.Test
    public void encodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.SearchProd;
        String expectedProductName = "Iphone XS";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeString(expectedProductName)
                .toByteArray();
        byte[] actualMessageBytes = new SearchProductMessage(expectedProductName).encode();
        assertArrayEquals(expectedMessageBytes, actualMessageBytes);
    }

    @org.junit.Test
    public void decodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.SearchProd;
        String expectedProductName = "Iphone XS";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeString(expectedProductName)
                .toByteArray();
        SearchProductMessage searchProductMessage = SearchProductMessage.decode(expectedMessageBytes);
        assertEquals(expectedProductName, searchProductMessage.getProdName());
    }
}
