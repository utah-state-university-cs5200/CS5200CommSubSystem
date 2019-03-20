package com.sub.system.communicators;

import java.util.HashMap;

public abstract class ConversationFactory {
    private HashMap<String, String> _typeMappings = new HashMap<>();

    public CommSubSystem ManagingSubsystem; // Create Getter And Setter
    public int DefaultMaxRetries; // Create Getter And Setter
    public int DefaultTimeout; // Create Getter And Setter

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
