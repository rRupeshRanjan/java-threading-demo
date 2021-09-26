package com.learning.javaDemos.implementations.calllablesImpl;

import com.learning.javaDemos.utils.HttpUtils;
import com.learning.javaDemos.utils.ResponseUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class CachedThreadPoolExecutorService {
    private static final HttpUtils httpUtils = HttpUtils.getInstance();
    private static final List<String> urls = httpUtils.getUrls();

    /**
     * Method : Executors.newCachedThreadPool()
     * A thread pool that creates as many threads it needs to execute the task in parallel.
     * The old available threads will be reused for the new tasks.
     * If a thread is not used during 60 seconds, it will be terminated and removed from the pool
     */
    public static void runInvokeAll() throws InterruptedException, ExecutionException {
        System.out.println(
                MessageFormat.format("[{0}]: Using cached threadpool - invokeAll", new Date().toInstant()));

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Callable<Map<String, Integer>>> callables = new ArrayList<>();
        urls.forEach(url -> callables.add(() -> httpUtils.makeHttpCalls(url)));

        List<Future<Map<String, Integer>>> futures = executorService.invokeAll(callables);

        ResponseUtils.extractResponses(futures);
        executorService.shutdown();
    }

    public static void runSubmit() throws ExecutionException, InterruptedException {
        System.out.println(
                MessageFormat.format("[{0}]: Using cached threadpool - submit", new Date().toInstant()));

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Map<String, Integer>>> futures = new ArrayList<>();

        urls.forEach(url -> futures.add(executorService.submit(() -> httpUtils.makeHttpCalls(url))));

        ResponseUtils.extractResponses(futures);
        executorService.shutdown();
    }
}
