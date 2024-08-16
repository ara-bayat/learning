package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorScedulert {

    private static final Logger log = LoggerFactory.getLogger(ThreadExecutorScedulert.class);


    public static void main(String[] args) throws InterruptedException {
        scheduled();
    }


    private static  void scheduled()
    {
        try(var executor = Executors.newSingleThreadScheduledExecutor())
        {
            executor.scheduleAtFixedRate(()->
            {
                log.info("thread scheduled");
            },0,1, TimeUnit.SECONDS);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
