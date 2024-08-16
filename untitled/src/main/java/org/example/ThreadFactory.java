package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ThreadFactory {

    private final static Integer MAX_PLATFORM = 10;
    private static final Logger log = LoggerFactory.getLogger(ThreadFactory.class);

    static {
        System.setProperty("jdk.virtualThreadScheduler.parallelism","1");
        System.setProperty("jdk.virtualThreadScheduler.maxPoolSize","1");
    }

    public static void main(String[] args) throws InterruptedException {
        demo(Thread.ofVirtual().factory());
        Thread.sleep(Duration.ofSeconds(2));
    }

    private static void demo(java.util.concurrent.ThreadFactory factory) {
        for (int i = 1; i <= 50; i++) {
            var t= factory.newThread(()->
            {

            });
            t.start();
        }
    }


}
