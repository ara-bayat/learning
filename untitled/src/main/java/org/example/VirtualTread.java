package org.example;

import java.util.concurrent.CountDownLatch;

public class VirtualTread {

    private final static Integer MAX_PLATFORM = 50_000;

    public static void main(String[] args) throws InterruptedException {
        platformThreadDemo4();
    }

    private static void platformThreadDemo() {
        for (int i = 1; i <= MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = new Thread(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    private static void platformThreadDemo2() {
        for (int i = 1; i <= MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = Thread.ofPlatform().unstarted(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    private static void platformThreadDemo3() {
        for (int i = 1; i <= MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = Thread.ofPlatform().unstarted(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    private static void platformThreadDemo4() throws InterruptedException {
        var latch = new CountDownLatch(MAX_PLATFORM);
        var builder = Thread.ofVirtual();
        for (int i = 1; i <= MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                latch.countDown();

            });
            thread.start();
        }
        latch.await();
    }
}
