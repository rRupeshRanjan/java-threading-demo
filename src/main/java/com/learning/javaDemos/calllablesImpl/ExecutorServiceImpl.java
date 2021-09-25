package com.learning.javaDemos.calllablesImpl;

import java.util.concurrent.ExecutionException;

public class ExecutorServiceImpl {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SingleThreadPoolExecutorService.run();

        FixedThreadPoolExecutorService.run(2);
        FixedThreadPoolExecutorService.run(4);

        CachedThreadPoolExecutorService.run();

        ScheduledThreadPoolExecutorService.run(2);
        ScheduledThreadPoolExecutorService.run(4);

        SingleThreadScheduledThreadPoolExecutorService.run();
    }
}
