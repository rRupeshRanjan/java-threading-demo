package com.learning.javaDemos.runnablesImpl;

import com.learning.javaDemos.utils.TaskUtils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        List<Task> tasks = TaskUtils.getTasks("CachedThreadPool");

        ExecutorService executorService = Executors.newCachedThreadPool();
        tasks.forEach(executorService::execute);

        executorService.shutdown();
    }
}
