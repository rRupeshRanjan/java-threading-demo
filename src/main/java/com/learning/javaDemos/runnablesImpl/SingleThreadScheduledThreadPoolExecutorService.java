package com.learning.javaDemos.runnablesImpl;

import com.learning.javaDemos.utils.TaskUtils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledThreadPoolExecutorService {
    /**
     * Method : Executors.newSingleThreadScheduledExecutor()
     * A thread pool with only one thread to schedule future task.
     * example:
     * To schedule after 5 seconds: executorService.schedule(callable, 5, TimeUnit.SECONDS)
     */
    public static void runExecute() {
        System.out.println(
                MessageFormat.format("[{0}]: Using Scheduled threadpool executor service", new Date().toInstant()));

        List<Task> tasks = TaskUtils.getTasks("SingleThreadScheduledTaskPool");

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        tasks.forEach(task -> executorService.schedule(task, 5, TimeUnit.SECONDS));
        executorService.shutdown();
    }
}
