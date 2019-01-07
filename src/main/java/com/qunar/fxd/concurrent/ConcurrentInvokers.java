package com.qunar.fxd.concurrent;

import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * ConcurrentInvoker 的封装类，增强ConcurrentInvoker功能
 */
public class ConcurrentInvokers {

    /**
     *
     * @param callback   正常业务callback
     * @param scheduledExecutorService  定时执行器
     * @param timeoutListener 超时回调
     * @param duration 超时时间
     */
    public static Runnable timeoutListeningDecorator(Runnable callback, ScheduledExecutorService scheduledExecutorService, Runnable timeoutListener, Duration duration) {
        return new TimeoutCallback(callback, timeoutListener, scheduledExecutorService, duration);
    }

    private static final class TimeoutCallback implements Runnable {

        private Runnable callback;

        private AtomicBoolean done = new AtomicBoolean(false);

        public TimeoutCallback(Runnable callback, Runnable timeoutTask, ScheduledExecutorService scheduledExecutorService, Duration duration) {
            this.callback = callback;
            scheduledExecutorService.schedule(() -> {
                if (done.compareAndSet(false, true)) {
                    timeoutTask.run();
                }
            }, duration.getSeconds(), TimeUnit.SECONDS);
        }


        @Override
        public void run() {
            if (done.compareAndSet(false, true)) {
                callback.run();
            }
        }
    }
}
