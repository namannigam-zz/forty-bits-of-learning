package edu.forty.bits.designing.messaging.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Queue;
import java.util.Set;

@Getter
@Setter
public class IMQueue {
    String queueId;
    String producerId;
    Queue<Message> messages;
    Set<String> consumerIds;
}
