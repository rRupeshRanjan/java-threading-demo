package com.learning.javaDemos.implementations.calllablesImpl;

import java.util.concurrent.ExecutionException;

public class CallableExecutorServiceImpl {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CallableExecutorServiceImpl service = new CallableExecutorServiceImpl();

        service.runSingleThreadExecutorService();
        service.runFixedThreadPoolExecutorService();
        service.runCachedThreadPoolExecutorService();
        service.runScheduledThreadPoolExecutorService();
        service.runSingleThreadScheduledThreadPoolExecutorService();
    }

    private void runSingleThreadExecutorService() throws ExecutionException, InterruptedException {
        SingleThreadPoolExecutorService.runInvokeAll();
        SingleThreadPoolExecutorService.runSubmit();
    }

    private void runFixedThreadPoolExecutorService() throws ExecutionException, InterruptedException {
        FixedThreadPoolExecutorService.runInvokeAll(2);
        FixedThreadPoolExecutorService.runInvokeAll(4);
        FixedThreadPoolExecutorService.runSubmit(2);
        FixedThreadPoolExecutorService.runSubmit(4);
    }

    private void runCachedThreadPoolExecutorService() throws ExecutionException, InterruptedException {
        CachedThreadPoolExecutorService.runInvokeAll();
        CachedThreadPoolExecutorService.runSubmit();
    }

    private void runScheduledThreadPoolExecutorService() throws ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutorService.run(2);
        ScheduledThreadPoolExecutorService.run(4);
    }

    private void runSingleThreadScheduledThreadPoolExecutorService() throws ExecutionException, InterruptedException {
        SingleThreadScheduledThreadPoolExecutorService.run();
    }
}
