package com.sub.system.communicators;

import java.util.HashMap;

public abstract class ConversationFactory {
    private HashMap<String, String> _typeMappings = new HashMap<>();

    public CommSubSystem ManagingSubsystem;
    public int DefaultMaxRetries;
    public int DefaultTimeout;

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

        return null;
    }
    public boolean canIncomingMessageStartConversation(String messageType)
    {
        return _typeMappings.containsKey(messageType);
    }

    public  Conversation CreateFromEnvelope(Envelope envelope)
    {
        Conversation conversation = null;
        String messageType = (String) envelope.getMessage();

        if (messageType != null && _typeMappings.containsKey(messageType))
            return CreateResponderConversation(_typeMappings.get(messageType), envelope);
        else
            return null;
    }

    public Conversation CreateResponderConversation(String s, Envelope envelope){
    return null;
    }


}
