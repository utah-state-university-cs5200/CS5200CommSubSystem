package test.java.Messages;

import com.hw2.LoginUserMessage;
import com.hw2.Message;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class LoginUserMessageTest {

    @org.junit.Test
    public void encodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.LoginUser;
        String expectedEmail = "adi.bhouraskar";
        String expectedPassword = "adi";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeString(expectedEmail)
                .encodeString(expectedPassword)
                .toByteArray();
        byte[] actualMessageBytes = new LoginUserMessage(expectedEmail,expectedPassword).encode();
        assertArrayEquals(expectedMessageBytes, actualMessageBytes);
    }

    @org.junit.Test
    public void decodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.LoginUser;
        String expectedEmail = "adi.bhouraskar";
        String expectedPassword = "adi";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeString(expectedEmail)
                .encodeString(expectedPassword)
                .toByteArray();
        LoginUserMessage loginUserMessage = LoginUserMessage.decode(expectedMessageBytes);
        assertEquals(expectedEmail,loginUserMessage.getEmail());
        assertEquals(expectedPassword, loginUserMessage.getPassword());
        assertEquals(expectedMessageType, loginUserMessage.getMessageType());
    }
}
