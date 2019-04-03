package com.sub.system.communicators;

import java.net.InetSocketAddress;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
public class Conversation {
    Queue<Envelope> IncomingEnvelopes = new ConcurrentLinkedQueue<Envelope>(); // Queue for Incoming Envelopes
    // For maintaining the state of a conversation
    public enum PossibleState {
        NotInitialized,
        Working,
        Failed,
        Succeed
    }

    public PossibleState State  = PossibleState.NotInitialized;

    public CommSubSystem CommSubsystem;
    public InetSocketAddress inetSocketAddress;

    public int Timeout = 3000;
    public int MaxRetries = 3;
    public String Error;
    public boolean Done;

    //    Conversation Id and Message Id, Need to resolve this
    //    We can go with Uid for conversation and message

    protected boolean Initialize()
    {
        State = PossibleState.Working;
        return true;
    }

    public void process(Envelope env)
    {
        if (env.getMessage() == null || env.getSrcInetSocketAddress() == null) return;
        IncomingEnvelopes.add(env);
    }
    protected boolean IsEnvelopeValid(Envelope env)
    {
        if (env.getMessage() == null)
            return false;
        else
            return true;
    }

    protected Envelope doReliableRequestReply(Envelope outgoingEnv) throws Exception
    {
        Envelope env = null;
       CommSubsystem.UdpComm.send(outgoingEnv);
        try {
             env = CommSubsystem.UdpComm.receive();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return env;
    }
}
