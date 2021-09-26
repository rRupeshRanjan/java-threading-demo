package com.learning.javaDemos.implementations.calllablesImpl;

import com.learning.javaDemos.utils.HttpUtils;
import com.learning.javaDemos.utils.ResponseUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class SingleThreadPoolExecutorService {
    private static final HttpUtils httpUtils = HttpUtils.getInstance();
    private static final List<String> urls = httpUtils.getUrls();

    /**
     * Executors.newSingleThreadExecutor()
     * A thread pool with only one thread.
     * All the submitted tasks will be executed sequentially.
     */
    public static void runInvokeAll() throws InterruptedException, ExecutionException {
        System.out.println(
                MessageFormat.format("[{0}]: Using Single threadpool - invokeAll", new Date().toInstant()));

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        List<Callable<Map<String, Integer>>> callables = new ArrayList<>();
        urls.forEach(url -> callables.add(() -> httpUtils.makeHttpCalls(url)));

        List<Future<Map<String, Integer>>> futures = executorService.invokeAll(callables);

        ResponseUtils.extractResponses(futures);
        executorService.shutdown();
    }

    public static void runSubmit() throws ExecutionException, InterruptedException {
        System.out.println(
                MessageFormat.format("[{0}]: Using Single threadpool - submit", new Date().toInstant()));

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        List<Future<Map<String, Integer>>> futures = new ArrayList<>();
        urls.forEach(url -> futures.add(executorService.submit(() -> httpUtils.makeHttpCalls(url))));

        ResponseUtils.extractResponses(futures);
        executorService.shutdown();
    }
}
