package com.learning.javaDemos.runnablesImpl;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task implements Runnable {
    private final String id;

    private Task(int id, String type) {
        this.id = "Task-" + id + "-" + type;
    }

    public static List<Task> getTasksWithType(String type) {
        return IntStream.range(1, 5)
                .mapToObj(i -> new Task(i, type))
                .collect(Collectors.toList());
    }

    public static List<Runnable> getRunnables(String type) {
        return IntStream.range(1, 5)
                .mapToObj(i ->
                        (Runnable) () -> {
                            System.out.println(MessageFormat.format("[{0}]: RunnableTask-{1}-{2} is running",
                                    new Date().toInstant(), i, type));
                            try {
                                Thread.sleep(new Random().nextInt(1000));
                            } catch (InterruptedException e) {
                                System.out.println("Exception occurred while sleeping");
                            }
                        })
                .collect(Collectors.toList());
    }

    @Override
    public void run() {
        System.out.println(MessageFormat.format("[{0}]: {1} is running", new Date().toInstant(), this.id));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
