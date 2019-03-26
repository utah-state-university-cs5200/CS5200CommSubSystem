package com.sub.system.communicators;

import com.hw2.Message;

import java.util.HashMap;

public class ConversationFactory {
    private HashMap<String, String> _typeMappings = new HashMap<>();

    public CommSubSystem ManagingSubsystem;
    public int DefaultMaxRetries;
    public int DefaultTimeout;

    public void Initialize() {

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
        Conversation conv = new Conversation();
        conv.setConvId("1");
        conv.MaxRetries = 2;
        conv.State = Conversation.PossibleState.Working;
        conv.MaxRetries = 4;
        return conv;
    }

    public boolean canIncomingMessageStartConversation(String messageType) {
        return _typeMappings.containsKey(messageType);
    }

    public  Conversation CreateFromEnvelope(Envelope envelope) {
        Conversation conversation = null;
        Message messageType = envelope.getMessage();

        if (messageType != null && _typeMappings.containsKey(messageType))
            return CreateResponderConversation(_typeMappings.get(messageType), envelope);
        else
            return null;
    }

    public Conversation CreateResponderConversation(String s, Envelope envelope){
    return new Conversation();
    }


}
