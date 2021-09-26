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
        SingleThreadPoolExecutorService.runSubmit();
    }

    private void runFixedThreadPoolExecutorService() {
        FixedThreadPoolExecutorService.runExecute(2);
        FixedThreadPoolExecutorService.runExecute(4);

        FixedThreadPoolExecutorService.runSubmit(2);
        FixedThreadPoolExecutorService.runSubmit(4);
    }

    private void runCachedThreadPoolExecutorService() {
        CachedThreadPoolExecutorService.runExecute();
        CachedThreadPoolExecutorService.runSubmit();
    }

    private void runScheduledThreadPoolExecutorService() {
        ScheduledThreadPoolExecutorService.run(2);
        ScheduledThreadPoolExecutorService.run(4);
    }

    private void runSingleThreadScheduledThreadPoolExecutorService() {
        SingleThreadScheduledThreadPoolExecutorService.run();
    }
}
