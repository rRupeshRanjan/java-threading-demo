package com.learning.javaDemos.runnablesImpl;

import java.text.MessageFormat;
import java.util.Date;

public class Task implements Runnable {
    private final String id;

    public Task(int id, String type) {
        this.id = "Task-" + id + "-" + type;
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
