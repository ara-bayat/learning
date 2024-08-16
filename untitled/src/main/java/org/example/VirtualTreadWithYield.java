package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

public class VirtualTreadWithYield {

    private final static Integer MAX_PLATFORM = 10;
    private static final Logger log = LoggerFactory.getLogger(VirtualTreadWithYield.class);

    static {
        System.setProperty("jdk.virtualThreadScheduler.parallelism","1");
        System.setProperty("jdk.virtualThreadScheduler.maxPoolSize","1");
    }

    public static void main(String[] args) throws InterruptedException {
        var builder=Thread.ofVirtual();
        var t1=builder.unstarted(()->demo(1));
        var t2=builder.unstarted(()->demo(2));
        t1.start();
        t2.start();
        Thread.sleep(Duration.ofSeconds(2));
    }

    private static void demo(int threadNumber) {
        log.info("thread-{} started", threadNumber);
        for (int i = 1; i <= MAX_PLATFORM; i++) {
            log.info("thread-{} in round {}", threadNumber,i);
            Thread.yield();
        }
        log.info("thread-{} finished", threadNumber);
    }


}
