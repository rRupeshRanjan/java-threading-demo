package com.learning.javaDemos.runnablesImpl;

import java.util.concurrent.ExecutionException;

public class ExecutorServiceImpl {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SingleThreadPoolExecutorService.run();

        FixedThreadPoolExecutorService.run(2);
        FixedThreadPoolExecutorService.run(5);

        CachedThreadPoolExecutorService.run();

        ScheduledThreadPoolExecutorService.run(2);
        ScheduledThreadPoolExecutorService.run(5);

        SingleThreadScheduledThreadPoolExecutorService.run();
    }
}
