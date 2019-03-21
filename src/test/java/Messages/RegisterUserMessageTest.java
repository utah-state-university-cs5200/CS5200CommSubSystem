package test.java.Messages;

import com.hw2.Message;
import com.hw2.RegisterUserMessage;

import java.io.IOException;

import static org.junit.Assert.*;

public class RegisterUserMessageTest {

    @org.junit.Test
    public void encodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.RegisterUser;
        short expectedUserId = 3;
        String expectedName = "aditya";
        String expectedEmailId = "adi.bhouraskar";
        String expectedPassword = "adi";
        String expectedAreaOfInterest = "tennis";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeShort(expectedUserId)
                .encodeString(expectedName)
                .encodeString(expectedEmailId)
                .encodeString(expectedPassword)
                .encodeString(expectedAreaOfInterest)
                .toByteArray();
        byte[] actualMessageBytes = new RegisterUserMessage(expectedUserId, expectedName, expectedEmailId, expectedPassword, expectedAreaOfInterest).encode();
        assertArrayEquals(expectedMessageBytes, actualMessageBytes);
    }

    @org.junit.Test
    public void decodeTest() throws IOException {
        Message.MessageType expectedMessageType = Message.MessageType.RegisterUser;
        short expectedUserId = 3;
        String expectedName = "aditya";
        String expectedEmailId = "adi.bhouraskar";
        String expectedPassword = "adi";
        String expectedAreaOfInterest = "tennis";
        byte[] expectedMessageBytes = new Message.Encoder()
                .encodeMessageType(expectedMessageType)
                .encodeShort(expectedUserId)
                .encodeString(expectedName)
                .encodeString(expectedEmailId)
                .encodeString(expectedPassword)
                .encodeString(expectedAreaOfInterest)
                .toByteArray();
        RegisterUserMessage registerUserMessage = RegisterUserMessage.decode(expectedMessageBytes);
        assertEquals(expectedUserId, registerUserMessage.getUserId());
        assertEquals(expectedName, registerUserMessage.getName());
        assertEquals(expectedEmailId, registerUserMessage.getEmailId());
        assertEquals(expectedPassword, registerUserMessage.getPassword());
        assertEquals(expectedAreaOfInterest, registerUserMessage.getAreaOfInterest());
        assertEquals(expectedMessageType, registerUserMessage.getMessageType());
    }
}
