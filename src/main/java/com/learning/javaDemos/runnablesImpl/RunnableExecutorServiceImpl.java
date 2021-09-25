package com.learning.javaDemos.runnablesImpl;

public class RunnableExecutorServiceImpl {
    public static void main(String[] args) {
        RunnableExecutorServiceImpl service = new RunnableExecutorServiceImpl();

        service.runSingleThreadExecutorService();
        service.runFixedThreadPoolExecutorService();
        service.runCachedThreadPoolExecutorService();
        service.runScheduledThreadPoolExecutorService();
        service.runSingleThreadScheduledThreadPoolExecutorService();
    }

    private void runSingleThreadExecutorService() {
        SingleThreadPoolExecutorService.runExecute();
    }

    private void runFixedThreadPoolExecutorService() {
        FixedThreadPoolExecutorService.runExecute(2);
        FixedThreadPoolExecutorService.runExecute(4);
    }

    private void runCachedThreadPoolExecutorService() {
        CachedThreadPoolExecutorService.runExecute();
    }

    private void runScheduledThreadPoolExecutorService() {
        ScheduledThreadPoolExecutorService.runExecute(2);
        ScheduledThreadPoolExecutorService.runExecute(4);
    }

    private void runSingleThreadScheduledThreadPoolExecutorService() {
        SingleThreadScheduledThreadPoolExecutorService.runExecute();
    }
}
