package com.learning.javaDemos.implementations.runnablesImpl;

import com.learning.javaDemos.domain.Task;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.learning.javaDemos.domain.ThreadPool.SINGLE_SCHEDULED_THREAD_POOL;

public class SingleThreadScheduledThreadPoolExecutorService {

    /**
     * Method : Executors.newSingleThreadScheduledExecutor()
     * A thread pool with only one thread to schedule future task.
     * example:
     * To schedule after 5 seconds: executorService.schedule(callable, 5, TimeUnit.SECONDS)
     */
    public static void run() {
        System.out.println(
                MessageFormat.format("[{0}]: Using Scheduled threadpool executor service", new Date().toInstant()));

        List<Task> tasks = Task.getTasksWithType(SINGLE_SCHEDULED_THREAD_POOL.getLabel());

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        tasks.forEach(task -> executorService.schedule(task, 5, TimeUnit.SECONDS));
        executorService.shutdown();
    }
}
