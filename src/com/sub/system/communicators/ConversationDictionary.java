package com.sub.system.communicators;

import java.util.HashMap;

public class ConversationDictionary {
private static HashMap<Integer, DictionaryQueue> messageQueues = new HashMap<>();

    public static DictionaryQueue getQueue(int conversationId)
    {
        if (messageQueues.containsKey(conversationId))
            return messageQueues.get(conversationId);
        else
        {
            DictionaryQueue messageQueue = new DictionaryQueue();
            messageQueues.put(conversationId, messageQueue);
            return messageQueue;
        }
    }

    public static boolean hasQueue(int conversationId)
    {
        return messageQueues.containsKey(conversationId);
    }
}

