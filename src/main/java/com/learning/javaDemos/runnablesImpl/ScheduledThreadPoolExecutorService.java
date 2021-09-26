package com.learning.javaDemos.runnablesImpl;

import com.learning.javaDemos.domain.Task;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.learning.javaDemos.ThreadPool.SCHEDULED_THREAD_POOL;

public class ScheduledThreadPoolExecutorService {

    /**
     * Method : Executors.newScheduledThreadPool()
     * A thread pool made to schedule future task.
     * example:
     * To schedule after 5 seconds: executorService.schedule(callable, 5, TimeUnit.SECONDS)
     */
    public static void run(int poolSize) {
        System.out.println(MessageFormat.format("[{0}]: Using Scheduled threadpool with {1} threads",
                new Date().toInstant(), poolSize));

        List<Task> tasks = Task.getTasksWithType(SCHEDULED_THREAD_POOL.getLabel());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(poolSize);
        tasks.forEach(task -> executorService.schedule(task, 5, TimeUnit.SECONDS));
        executorService.shutdown();
    }
}
