package com.sub.system.communicators;

import java.util.HashMap;

public abstract class ConversationFactory {
    private HashMap<String, String> _typeMappings = new HashMap<>();

    public CommSubSystem ManagingSubsystem; // Create Getter And Setter
    public int DefaultMaxRetries; // Create Getter And Setter
    public int DefaultTimeout; // Create Getter And Setter

    public abstract void Initialize();

    public HashMap<String, String> get_typeMappings() {
        return _typeMappings;
    }

    public void set_typeMappings(HashMap<String, String> _typeMappings) {
        this._typeMappings = _typeMappings;
    }

    public CommSubSystem getManagingSubsystem() {
        return ManagingSubsystem;
    }

    public void setManagingSubsystem(CommSubSystem managingSubsystem) {
        ManagingSubsystem = managingSubsystem;
    }

    public int getDefaultMaxRetries() {
        return DefaultMaxRetries;
    }

    public void setDefaultMaxRetries(int defaultMaxRetries) {
        DefaultMaxRetries = defaultMaxRetries;
    }

    public int getDefaultTimeout() {
        return DefaultTimeout;
    }

    public void setDefaultTimeout(int defaultTimeout) {
        DefaultTimeout = defaultTimeout;
    }

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
