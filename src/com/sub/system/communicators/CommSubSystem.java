package com.sub.system.communicators;
import java.net.InetSocketAddress;

public class CommSubSystem {
    private InetSocketAddress bestAddress;
    private ConversationFactory conversationFactory;
    private int minPort;
    private int maxPort;

    public int Port = 8080;
    public String BestLocalEndPoint = "";
    public ConversationDictionary Conversations;
    public UDPComm UdpCommunicator;

    public CommSubSystem(ConversationFactory factory, int minPort, int maxPort)
    {
        conversationFactory = factory;
        conversationFactory.ManagingSubsystem = this;

        minPort = minPort;
        maxPort = maxPort;

        Conversations = new ConversationDictionary();
    }

    public void Initialize()
    {

    }
}
