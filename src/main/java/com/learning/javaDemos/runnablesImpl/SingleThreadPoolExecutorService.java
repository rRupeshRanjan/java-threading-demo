package com.learning.javaDemos.runnablesImpl;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.learning.javaDemos.ThreadPool.SINGLE_THREAD_POOL;

public class SingleThreadPoolExecutorService {

    /**
     * Executors.newSingleThreadExecutor()
     * A thread pool with only one thread.
     * All the submitted tasks will be executed sequentially.
     */
    public static void runExecute() {
        System.out.println(
                MessageFormat.format("[{0}]: Using Single threadpool - execute", new Date().toInstant()));

        List<Task> tasks = Task.getTasksWithType(SINGLE_THREAD_POOL.getLabel());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }

    public static void runSubmit() {
        System.out.println(
                MessageFormat.format("[{0}]: Using Single threadpool - submit", new Date().toInstant()));

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        List<Runnable> runnables = Task.getRunnables(SINGLE_THREAD_POOL.getLabel());

        runnables.forEach(executorService::submit);
        executorService.shutdown();
    }
}
