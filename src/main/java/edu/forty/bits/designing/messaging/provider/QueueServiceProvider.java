package edu.forty.bits.designing.messaging.provider;

import edu.forty.bits.designing.messaging.entity.IMQueue;
import edu.forty.bits.designing.messaging.entity.Message;
import edu.forty.bits.designing.messaging.service.QueueService;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class QueueServiceProvider implements QueueService {

    public void addMessage(String queueId, String producerId, Message message) {
        IMQueue imQueue = getById(queueId);
        validateProducer(imQueue, producerId); // handle exceptions
        imQueue.getMessages().add(message); // update the entity
        System.out.println(message.getMessageId() + " produced by " + producerId + " added to " + queueId);
        // ac
        notifyConsumers(queueId);
    }


    // optimise on addMessage and notify with a single call to get imQueue
    public void notifyConsumers(String queueId) {
        SinkProvider sinkProvider = new SinkProvider();
        IMQueue imQueue = getById(queueId);
        Set<String> consumers = imQueue.getConsumerIds();
        for (String consumerId : consumers) {
            sinkProvider.notified(queueId, consumerId);
            System.out.println(consumerId + " got notified by " + queueId);
        }
    }

    public Message readTopMessage(String queueId) {
        IMQueue imQueue = getById(queueId);
        return imQueue.getMessages().peek();
    }


    private boolean validateProducer(IMQueue imQueue, String producerId) {
        return imQueue.getProducerId().equals(producerId);
    }


    // currently mocked
    private IMQueue getById(String queueId) {
        IMQueue imQueue = new IMQueue();
        Set<String> consumers = new HashSet<String>();
        consumers.add("C1");
        consumers.add("C2");
        consumers.add("C3");
        imQueue.setConsumerIds(consumers);
        imQueue.setQueueId(queueId);
        imQueue.setProducerId("P1");
        LinkedList<Message> messages = new LinkedList<Message>();
        messages.add(Message.builder().messageId("M1").text("Dummy").build());
        imQueue.setMessages(messages); // mocking
        return imQueue;
    }
}