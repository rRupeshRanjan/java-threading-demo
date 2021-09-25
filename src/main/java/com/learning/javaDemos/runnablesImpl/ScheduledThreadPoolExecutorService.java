package com.learning.javaDemos.runnablesImpl;

import com.learning.javaDemos.utils.TaskUtils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScheduledThreadPoolExecutorService {
    /**
     * Method : Executors.newScheduledThreadPool()
     * A thread pool made to schedule future task.
     * example:
     * To schedule after 5 seconds: executorService.schedule(callable, 5, TimeUnit.SECONDS)
     */
    public static void run(int poolSize) throws InterruptedException, ExecutionException {
        System.out.println(
                MessageFormat.format("[{0}]: Using Scheduled threadpool executor service", new Date().toInstant()));

        List<Task> tasks = TaskUtils.getTasks("ScheduledThreadPool");

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(poolSize);
        tasks.forEach(task -> executorService.schedule(task, 5, TimeUnit.SECONDS));
        executorService.shutdown();
    }
}
