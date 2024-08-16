package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Task {
    private  static  final Logger log=LoggerFactory.getLogger(Task.class);
    public static void ioIntensive(Integer number) {
        try {
            log.info("starting I/O task {}",number);
            Thread.sleep(Duration.ofSeconds(10));
            log.info("finishing I/O task {}",number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
