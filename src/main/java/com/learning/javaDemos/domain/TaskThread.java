package com.learning.javaDemos.domain;

import java.text.MessageFormat;
import java.util.Date;

public class TaskThread extends Thread {
    private final String id;

    public TaskThread(int id, String type) {
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
