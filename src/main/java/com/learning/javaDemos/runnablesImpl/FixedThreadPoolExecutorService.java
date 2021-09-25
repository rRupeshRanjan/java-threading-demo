package com.learning.javaDemos.runnablesImpl;

import com.learning.javaDemos.utils.TaskUtils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutorService {
    /**
     * Method : Executors.newFixedThreadPool()
     * A thread pool with a fixed number of threads.
     * If a thread is not available for the task, the task is put in queue waiting for other task to end.
     */
    public static void runExecute(int threads) throws InterruptedException, ExecutionException {
        System.out.println(MessageFormat.format("[{0}]: Using Fixed threadpool with {1} threads - execute",
                new Date().toInstant(), threads));

        List<Task> tasks = TaskUtils.getTasks("FixedThreadPool");

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }
}
