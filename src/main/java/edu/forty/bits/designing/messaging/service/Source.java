package edu.forty.bits.designing.messaging.service;

import edu.forty.bits.designing.messaging.entity.Message;

public interface Source {

    boolean produce(String queueId, String producerId, Message message);
}