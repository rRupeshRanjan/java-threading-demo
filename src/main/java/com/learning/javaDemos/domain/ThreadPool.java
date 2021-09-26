package com.learning.javaDemos.domain;

public enum ThreadPool {
    SINGLE_THREAD_POOL("singleThreadPool"),
    FIXED_THREAD_POOL("fixedThreadPool"),
    CACHED_THREAD_POOL("cachedThreadPool"),
    SCHEDULED_THREAD_POOL("scheduledThreadPool"),
    SINGLE_SCHEDULED_THREAD_POOL("singleScheduledThreadPool");

    private final String label;

    ThreadPool(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
