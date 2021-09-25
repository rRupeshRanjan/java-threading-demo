package com.learning.javaDemos.calllablesImpl;

import com.learning.javaDemos.utils.HttpUtils;
import com.learning.javaDemos.utils.ResponseUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class SingleThreadScheduledThreadPoolExecutorService {
    private static final HttpUtils httpUtils = HttpUtils.getInstance();
    private static final List<String> urls = httpUtils.getUrls();

    /**
     * Method : Executors.newSingleThreadScheduledExecutor()
     * A thread pool with only one thread to schedule future task.
     * example:
     * To schedule after 5 seconds: executorService.schedule(callable, 5, TimeUnit.SECONDS)
     */
    public static void run() throws InterruptedException, ExecutionException {
        System.out.println(MessageFormat.format("[{0}]: Using Single Scheduled threadpool - schedule",
                new Date().toInstant()));

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        List<ScheduledFuture<Map<String, Integer>>> futures = new ArrayList<>();

        urls.forEach(url -> futures.add(
                executorService.schedule(() -> httpUtils.makeHttpCalls(url), 5, TimeUnit.SECONDS)));

        ResponseUtils.extractScheduledResponses(futures);
        executorService.shutdown();
    }
}
