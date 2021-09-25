package com.learning.javaDemos.runnablesImpl;

import com.learning.javaDemos.utils.TaskUtils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolExecutorService {

    /**
     * Executors.newSingleThreadExecutor()
     * A thread pool with only one thread.
     * All the submitted tasks will be executed sequentially.
     */
    public static void run() {
        System.out.println(
                MessageFormat.format("[{0}]: Using Single threadpool executor service", new Date().toInstant()));

        List<Task> tasks = TaskUtils.getTasks("singleThreadPool");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }
}
