package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExecutor {

    private static final Logger log = LoggerFactory.getLogger(ThreadExecutor.class);


    public static void main(String[] args) throws InterruptedException {
        try (var threadExecutor = Executors.newSingleThreadExecutor()) {
            threadExecutor.submit(ThreadExecutor::demo);
            log.info("thread start");
        }
    }




    private static void demo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("thread done");

    }


}
