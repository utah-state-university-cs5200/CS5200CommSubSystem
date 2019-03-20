package com.sub.system.communicators;
import java.net.InetSocketAddress;

public class CommSubSystem {
    private InetSocketAddress bestAddress;
    private ConversationFactory convFact;
    private Conversation conv;
    private Dispatcher disp;
    private Envelope env;
    private ConversationDictionary convDict;
    public UDPComm UdpComm;
    public TCPComm TcpComm;

    public ConversationDictionary getConvDict() {
        return convDict;
    }

    public void setConvDict(ConversationDictionary convDict) {
        this.convDict = convDict;
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

    private int _minPort;
    private int _maxPort;

    public int port = 8080;
    public String BestLocalEndPoint = "";


    public CommSubSystem(ConversationFactory factory, int minPort, int maxPort)
    {
        convFact = factory;
        _minPort = minPort;
        _maxPort = maxPort;
        convFact.ManagingSubsystem = this;
        convDict = new ConversationDictionary();
    }

    public void Initialize()
    {
        convFact.Initialize();


    }

    public void Stop(int flag)
    {
        if (UdpComm != null)
        {
//            UdpComm.Stop();
            UdpComm = null;
        }
    }
}
