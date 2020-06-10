package org.vander;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerThreadPool {
    public static void main(String[] args) {
        int producerThreadNumber = 20;
        int topicNumber = 20;

        String url = "pulsar://localhost:6650";
        String topicName = "my-topic-";
        int sleepTime = 1000;  //milliseconds
        int size = 1024;   //byte

        ExecutorService pool = Executors.newFixedThreadPool(producerThreadNumber);
        for (int topicIndex = 0; topicIndex < topicNumber; topicIndex++) {
            pool.submit(new ProducerRunnable(url, topicName + Integer.toString(topicIndex), sleepTime, size));
        }
        pool.shutdown();
    }
}
