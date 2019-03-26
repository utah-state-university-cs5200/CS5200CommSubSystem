package com.sub.system.communicators;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;

public class CommSubSystem {
    private InetSocketAddress bestAddress;
    private ConversationFactory convFact;
    private Conversation conv;
    private Dispatcher disp;
    private Envelope env;
    private ConversationDictionary convDict;
    public UDPComm UdpComm;
    public TCPComm TcpComm;
    private int _minPort;
    private int _maxPort;

    private static HashMap<Integer, Boolean> usedPort = new HashMap<Integer, Boolean>();
    private static int currentPort = 8080;

    public static int nextAvailablePort()
    {
        while (usedPort.containsKey(currentPort))
            currentPort++;

        usedPort.put(currentPort, true);

        return currentPort++;
    }

    private static void markPortUsed(int port)
    {
        if (!usedPort.containsKey(port))
            usedPort.put(port, true);
    }

    public UDPComm getUdpComm() {
        return UdpComm;
    }

    public void setUdpComm(UDPComm udpComm) {
        UdpComm = udpComm;
    }

    public TCPComm getTcpComm() {
        return TcpComm;
    }

    public void setTcpComm(TCPComm tcpComm) {
        TcpComm = tcpComm;
    }


    public CommSubSystem(ConversationFactory factory, int minPort, int maxPort)
    {
        convFact = factory;
        _minPort = minPort;
        _maxPort = maxPort;
        convFact.ManagingSubsystem = this;
        convDict = new ConversationDictionary();
    }

    public void Initialize() throws IOException {
        convFact.Initialize();
        try {
            UdpComm.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stop(int flag) throws IOException {
        if (UdpComm != null)
        {
            try {
                UdpComm.stop();
                UdpComm = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void sending(int flag)
    {
        if (UdpComm != null)
        {

        }
    }
    public void receiving(int flag) throws IOException {
        if (UdpComm != null)
        {
            UdpComm.receive();
        }
    }
}
