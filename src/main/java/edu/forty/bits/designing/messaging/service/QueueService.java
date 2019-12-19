package edu.forty.bits.designing.messaging.service;

import edu.forty.bits.designing.messaging.entity.Message;

public interface QueueService {

    void addMessage(String queueId, String producerId, Message message);

    void notifyConsumers(String queueId);

    Message readTopMessage(String queueId);
}