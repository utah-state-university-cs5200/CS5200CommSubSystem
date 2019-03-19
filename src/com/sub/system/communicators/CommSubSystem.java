package com.sub.system.communicators;
import java.net.InetSocketAddress;

public class CommSubSystem {
    private InetSocketAddress inetSocketAddress;
    private String _bestAddress;
    private ConversationFactory _conversationFactory;
    private int _minPort;
    private int _maxPort;
}
