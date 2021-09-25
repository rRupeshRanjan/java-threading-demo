package com.learning.javaDemos.calllablesImpl;

import com.learning.javaDemos.utils.HttpUtils;
import com.learning.javaDemos.utils.ResponseUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class SingleThreadPoolExecutorService {

    /**
     * Executors.newSingleThreadExecutor()
     * A thread pool with only one thread.
     * All the submitted tasks will be executed sequentially.
     */
    public static void run() throws InterruptedException, ExecutionException {
        System.out.println(
                MessageFormat.format("[{0}]: Using Single threadpool executor service", new Date().toInstant()));

        HttpUtils httpUtils = HttpUtils.getInstance();
        List<String> urls = httpUtils.getUrls();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Callable<Map<String, Integer>>> callables = new ArrayList<>();

        urls.forEach(url -> callables.add(() -> httpUtils.makeHttpCalls(url)));

        List<Future<Map<String, Integer>>> futures = executorService.invokeAll(callables);

        ResponseUtils.extractResponses(futures);
        executorService.shutdown();
    }
}
