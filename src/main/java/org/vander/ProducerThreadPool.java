package org.vander;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerThreadPool {
    public static void main(String[] args) {
        int producerThreadNumber = 20;
        int topicNumber = 50;

        String url = "pulsar://localhost:6650";
        String topicName = "my-topic-";
        int sleepTime = 1000;

        ExecutorService pool = Executors.newFixedThreadPool(producerThreadNumber);
        for (int topicIndex = 0; topicIndex < topicNumber; topicIndex++) {
            pool.submit(new ProducerRunnable(url, topicName + Integer.toString(topicIndex), sleepTime));
        }
        pool.shutdown();
    }
}
