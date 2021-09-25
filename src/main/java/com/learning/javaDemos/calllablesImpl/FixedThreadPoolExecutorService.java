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
    /**
     * Method : Executors.newFixedThreadPool()
     * A thread pool with a fixed number of threads.
     * If a thread is not available for the task, the task is put in queue waiting for other task to end.
     */
    public static void run(int threads) throws InterruptedException, ExecutionException {
        System.out.println(
                MessageFormat.format("[{0}]: Using Fixed threadpool executor service", new Date().toInstant()));

        HttpUtils httpUtils = HttpUtils.getInstance();
        List<String> urls = httpUtils.getUrls();

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        List<Callable<Map<String, Integer>>> callables = new ArrayList<>();

        urls.forEach(url -> callables.add(() -> httpUtils.makeHttpCalls(url)));

        List<Future<Map<String, Integer>>> futures = executorService.invokeAll(callables);

        ResponseUtils.extractResponses(futures);
        executorService.shutdown();
    }
}
