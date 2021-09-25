package com.learning.javaDemos.runnablesImpl;

import java.util.concurrent.ExecutionException;

public class RunnableExecutorServiceImpl {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        RunnableExecutorServiceImpl service = new RunnableExecutorServiceImpl();

        service.runSingleThreadExecutorService();
        service.runFixedThreadPoolExecutorService();
        service.runCachedThreadPoolExecutorService();
        service.runScheduledThreadPoolExecutorService();
        service.runSingleThreadScheduledThreadPoolExecutorService();
    }

    private void runSingleThreadExecutorService() throws ExecutionException, InterruptedException {
        SingleThreadPoolExecutorService.runExecute();
    }

    private void runFixedThreadPoolExecutorService() throws ExecutionException, InterruptedException {
        FixedThreadPoolExecutorService.runExecute(2);
        FixedThreadPoolExecutorService.runExecute(4);
    }

    private void runCachedThreadPoolExecutorService() throws ExecutionException, InterruptedException {
        CachedThreadPoolExecutorService.runExecute();
    }

    private void runScheduledThreadPoolExecutorService() throws ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutorService.runExecute(2);
        ScheduledThreadPoolExecutorService.runExecute(4);
    }

    private void runSingleThreadScheduledThreadPoolExecutorService() throws ExecutionException, InterruptedException {
        SingleThreadScheduledThreadPoolExecutorService.runExecute();
    }
}
