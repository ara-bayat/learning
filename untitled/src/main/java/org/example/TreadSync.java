package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TreadSync {

    private final static Integer MAX_PLATFORM = 10;
    private static final Logger log = LoggerFactory.getLogger(TreadSync.class);
    private static final List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        var builder=Thread.ofPlatform();
        var t1=builder.unstarted(()->demo(builder));
        t1.start();
        Thread.sleep(Duration.ofSeconds(2));
        log.info("List size id : {}", list.size());
    }

    private static void demo(Thread.Builder builder) {
        for (int i = 1; i <= 50; i++) {
            builder.start(()->
            {
                for (int j = 0; j < 200; j++) {
                    task();
                }
            });
        }
    }
    private static synchronized void task() {
        list.add(1);
    }


}
