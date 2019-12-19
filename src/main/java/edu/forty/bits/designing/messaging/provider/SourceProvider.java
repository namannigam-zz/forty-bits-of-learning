package edu.forty.bits.designing.messaging.provider;

import edu.forty.bits.designing.messaging.entity.Message;
import edu.forty.bits.designing.messaging.service.Source;

public class SourceProvider implements Source {

    QueueServiceProvider queueServiceProvider;

    public SourceProvider() {
        queueServiceProvider = new QueueServiceProvider();
    }

    public boolean produce(String queueId, String producerId, Message message) {
        System.out.println(producerId + " produced message " + message.getMessageId() + " to " + queueId); // producing
        queueServiceProvider.addMessage(queueId, producerId, message);
        return false;
    }
}
