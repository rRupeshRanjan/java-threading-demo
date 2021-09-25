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

public class FixedThreadPoolExecutorService {
    /**
     * Method : Executors.newFixedThreadPool()
     * A thread pool with a fixed number of threads.
     * If a thread is not available for the task, the task is put in queue waiting for other task to end.
     */
    public static void run(int threads) throws InterruptedException, ExecutionException {
        System.out.println(
                MessageFormat.format("[{0}]: Using Fixed threadpool executor service", new Date().toInstant()));

        List<Task> tasks = TaskUtils.getTasks("FixedThreadPool");

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }
}
