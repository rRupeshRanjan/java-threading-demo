package com.learning.javaDemos.runnablesImpl;

import com.learning.javaDemos.domain.Task;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.learning.javaDemos.ThreadPool.CACHED_THREAD_POOL;
import static com.learning.javaDemos.ThreadPool.FIXED_THREAD_POOL;

public class CachedThreadPoolExecutorService {

    /**
     * Method : Executors.newCachedThreadPool()
     * A thread pool that creates as many threads it needs to execute the task in parallel.
     * The old available threads will be reused for the new tasks.
     * If a thread is not used during 60 seconds, it will be terminated and removed from the pool
     */
    public static void runExecute() {
        System.out.println(
                MessageFormat.format("[{0}]: Using cached threadpool - execute", new Date().toInstant()));

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Task> tasks = Task.getTasksWithType(CACHED_THREAD_POOL.getLabel());

        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }

    public static void runSubmit() {
        System.out.println(
                MessageFormat.format("[{0}]: Using cached threadpool - submit", new Date().toInstant()));

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Runnable> runnables = Task.getRunnables(FIXED_THREAD_POOL.getLabel());

        runnables.forEach(executorService::submit);
        executorService.shutdown();
    }
}
