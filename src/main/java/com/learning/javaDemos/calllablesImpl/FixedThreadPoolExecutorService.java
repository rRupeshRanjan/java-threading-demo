package com.learning.javaDemos.calllablesImpl;

import com.learning.javaDemos.utils.HttpUtils;
import com.learning.javaDemos.utils.ResponseUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class FixedThreadPoolExecutorService {
    private static HttpUtils httpUtils = HttpUtils.getInstance();
    private static List<String> urls = httpUtils.getUrls();

    /**
     * Method : Executors.newFixedThreadPool()
     * A thread pool with a fixed number of threads.
     * If a thread is not available for the task, the task is put in queue waiting for other task to end.
     */
    public static void runInvokeAll(int threads) throws InterruptedException, ExecutionException {
        System.out.println(
                MessageFormat.format("[{0}]: Using Fixed threadpool with {1} threads - invokeAll",
                        new Date().toInstant(), threads));

        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        List<Callable<Map<String, Integer>>> callables = new ArrayList<>();
        urls.forEach(url -> callables.add(() -> httpUtils.makeHttpCalls(url)));

        List<Future<Map<String, Integer>>> futures = executorService.invokeAll(callables);

        ResponseUtils.extractResponses(futures);
        executorService.shutdown();
    }

    public static void runSubmit(int threads) throws InterruptedException, ExecutionException {
        System.out.println(
                MessageFormat.format("[{0}]: Using Fixed threadpool with {1} threads - submit",
                        new Date().toInstant(), threads));

        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        List<Future<Map<String, Integer>>> futures = new ArrayList<>();
        urls.forEach(url -> futures.add(executorService.submit(() -> httpUtils.makeHttpCalls(url))));

        ResponseUtils.extractResponses(futures);
        executorService.shutdown();
    }
}
