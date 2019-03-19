package com.sub.system.communicators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public abstract class Conversation {
    Queue<Envelope> IncomingEnvelopes = new ConcurrentLinkedQueue<Envelope>();
    // getter setter PossibleState
    public enum PossibleState {
        NotInitialized,
        Working,
        Failed,
        Succeed
    }

    public PossibleState State  = PossibleState.NotInitialized;

    public CommSubSystem CommSubsystem; // getter setter
    public InetSocketAddress inetSocketAddress; // getter setter
    public int Timeout = 3000;
    public int MaxRetries = 3;
//    public MessageId ConvId;    // Why we needed to create MessageId Class
    public String ConvId; // getter setter
    public String Error;
    public boolean Done;

    public void Launch(Object context)
    {
        ExecutorService pool = Executors.newFixedThreadPool(3);
    }

    public void Execute(Object context)
    {
        if (Initialize())
            ExecuteDetails(context);
    }

    protected boolean Initialize()
    {
        State = PossibleState.Working;
        return true;
    }

    protected abstract void ExecuteDetails(Object context);

    public void Process(Envelope env)
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
}
