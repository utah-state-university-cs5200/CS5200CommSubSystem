package com.sub.system.communicators;

import java.util.concurrent.ConcurrentHashMap;

public class ConversationDictionary {
    ConversationDictionary convDict;
    ConcurrentHashMap<String, Conversation> activeConversation =  new ConcurrentHashMap<String, Conversation>();
    public ConversationDictionary getConvDict() {
        return convDict;
    }

    public void setConvDict(ConversationDictionary convDict) {
        this.convDict = convDict;
    }

    public void addConversation(Conversation conversation)
    {
        if (conversation == null) return;

        Conversation existingConversation = lookUpConversation(conversation.ConvId);
        if (existingConversation == null)
            activeConversation.put(conversation.ConvId, conversation);
    }

    public Conversation lookUpConversation(String convId){
        Conversation conv = activeConversation.get(convId);
        return conv;
    }

    public void remove(String convId)
    {
        Conversation conversation;
        activeConversation.remove(convId);
    }

    public void removeAll(){
        activeConversation.clear();
    }
}
