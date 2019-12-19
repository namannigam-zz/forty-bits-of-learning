package edu.forty.bits.designing.messaging.service;


public interface Sink {

    void notified(String queueId, String consumerId);

    void consume(String queueId, String consumerId);
}