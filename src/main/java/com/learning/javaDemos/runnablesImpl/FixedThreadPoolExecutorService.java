package com.learning.javaDemos.runnablesImpl;

import com.learning.javaDemos.domain.Task;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.learning.javaDemos.ThreadPool.FIXED_THREAD_POOL;

public class FixedThreadPoolExecutorService {

    /**
     * Method : Executors.newFixedThreadPool()
     * A thread pool with a fixed number of threads.
     * If a thread is not available for the task, the task is put in queue waiting for other task to end.
     */
    public static void runExecute(int threads) {
        System.out.println(MessageFormat.format("[{0}]: Using Fixed threadpool with {1} threads - execute",
                new Date().toInstant(), threads));

        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        List<Task> tasks = Task.getTasksWithType(FIXED_THREAD_POOL.getLabel());

        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }

    public static void runSubmit(int threads) {
        System.out.println(MessageFormat.format("[{0}]: Using Fixed threadpool with {1} threads - submit",
                new Date().toInstant(), threads));

        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        List<Runnable> runnables = Task.getRunnables(FIXED_THREAD_POOL.getLabel());

        runnables.forEach(executorService::submit);
        executorService.shutdown();
    }
}
