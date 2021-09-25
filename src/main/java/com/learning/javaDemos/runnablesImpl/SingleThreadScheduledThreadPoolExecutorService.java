package com.learning.javaDemos.runnablesImpl;

import com.learning.javaDemos.utils.HttpUtils;
import com.learning.javaDemos.utils.ResponseUtils;
import com.learning.javaDemos.utils.TaskUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SingleThreadScheduledThreadPoolExecutorService {
    /**
     * Method : Executors.newSingleThreadScheduledExecutor()
     * A thread pool with only one thread to schedule future task.
     * example:
     * To schedule after 5 seconds: executorService.schedule(callable, 5, TimeUnit.SECONDS)
     */
    public static void runExecute() throws InterruptedException, ExecutionException {
        System.out.println(
                MessageFormat.format("[{0}]: Using Scheduled threadpool executor service", new Date().toInstant()));

        List<Task> tasks = TaskUtils.getTasks("SingleThreadScheduledTaskPool");

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        tasks.forEach(task -> executorService.schedule(task, 5, TimeUnit.SECONDS));
        executorService.shutdown();
    }
}
