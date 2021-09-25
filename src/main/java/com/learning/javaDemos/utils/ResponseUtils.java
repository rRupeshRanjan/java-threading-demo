package com.learning.javaDemos.utils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

public class ResponseUtils {
    public static void printResponses(Map<String, Integer> responses) {
        responses.forEach((key, value) ->
                System.out.println(MessageFormat.format("[{0}]: {1} - {2}", new Date().toInstant(), key, value)));
        System.out.println();
    }

    public static void extractResponses(List<Future<Map<String, Integer>>> futures)
            throws ExecutionException, InterruptedException {
        Map<String, Integer> responses = new HashMap<>();
        while (responses.size() != futures.size()) {
            for (Future<Map<String, Integer>> future : futures) {
                if (future.isDone())
                    responses.putAll(future.get());
            }
        }

        printResponses(responses);
    }

    public static void extractScheduledResponses(List<ScheduledFuture<Map<String, Integer>>> futures)
            throws ExecutionException, InterruptedException {
        Map<String, Integer> responses = new HashMap<>();
        while (responses.size() != futures.size()) {
            for (Future<Map<String, Integer>> future : futures) {
                if (future.isDone())
                    responses.putAll(future.get());
            }
        }

        printResponses(responses);
    }
}
