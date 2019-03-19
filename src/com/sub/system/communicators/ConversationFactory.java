package com.sub.system.communicators;

import java.util.HashMap;

public abstract class ConversationFactory {
    private HashMap<String, String> _typeMappings = new HashMap<>();

    public CommSubSystem ManagingSubsystem;
    public int DefaultMaxRetries;
    public int DefaultTimeout;

    public abstract void Initialize();

    protected void Add(String messageType, String conversationType)
    {
        if (!_typeMappings.containsKey(messageType))
            _typeMappings.put(messageType, conversationType);
    }

    public Conversation CreateFromConversationType() {
//        Conversation conversation  = ManagingSubsystem;
        return null;
    }
}
