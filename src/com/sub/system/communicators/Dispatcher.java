package com.sub.system.communicators;

public class Dispatcher implements Runnable {
    public void run() {

        // Loop until stopped
            // Try to getEnvelope from UDPCommeuncator with without
            // If got a envelope
                // lookup conversation in the Conversation Dictionary using the conversation id in the message
                // If conversation exists
                    // converstation.Process(envelope)
                // else
                    // create conversation using the conversation factory

    }
}
