package com.learning.javaDemos.implementations.calllablesImpl;

import com.learning.javaDemos.utils.HttpUtils;
import com.learning.javaDemos.utils.ResponseUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorService {
    private static final HttpUtils httpUtils = HttpUtils.getInstance();
    private static final List<String> urls = httpUtils.getUrls();

    /**
     * Method : Executors.newScheduledThreadPool()
     * A thread pool made to schedule future task.
     * example:
     * To schedule after 5 seconds: executorService.schedule(callable, 5, TimeUnit.SECONDS)
     */
    public static void run(int poolSize) throws InterruptedException, ExecutionException {
        System.out.println(MessageFormat.format("[{0}]: Using Scheduled threadpool with {1} threads - schedule",
                new Date().toInstant(), poolSize));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(poolSize);
        List<ScheduledFuture<Map<String, Integer>>> futures = new ArrayList<>();

        urls.forEach(url -> futures.add(
                executorService.schedule(() -> httpUtils.makeHttpCalls(url), 5, TimeUnit.SECONDS)));

        ResponseUtils.extractScheduledResponses(futures);
        executorService.shutdown();
    }
}
