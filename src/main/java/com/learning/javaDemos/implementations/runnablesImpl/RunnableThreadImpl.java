package com.learning.javaDemos.implementations.runnablesImpl;

import com.learning.javaDemos.domain.TaskThread;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunnableThreadImpl {
    public static void main(String[] args) {
        RunnableThreadImpl runnableThreadImpl = new RunnableThreadImpl();
        runnableThreadImpl.runRunnablesWithThread();
    }

    private void runRunnablesWithThread() {
        IntStream.range(1,20)
                .mapToObj(i -> new TaskThread(i, "runnableThread"))
                .collect(Collectors.toList())
                .forEach(TaskThread::start);
    }
}
