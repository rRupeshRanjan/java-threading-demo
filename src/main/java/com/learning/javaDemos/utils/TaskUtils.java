package com.learning.javaDemos.utils;

import com.learning.javaDemos.runnablesImpl.Task;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskUtils {
    public static List<Task> getTasks(String type) {
        return IntStream.range(1,5)
                .mapToObj(i -> new Task(i, type))
                .collect(Collectors.toList());
    }
}
