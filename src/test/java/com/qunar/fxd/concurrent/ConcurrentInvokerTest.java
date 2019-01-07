package com.qunar.fxd.concurrent;


import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ConcurrentInvokerTest {


    public static void helloWorld1(int n) throws InterruptedException {
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; ++i) {
            threads[i] = new Thread(() -> System.out.println("Hello World!"));
            threads[i].start();
        }
        for (int i = 0; i < n; ++i) {
            threads[i].join();
        }
        System.out.println("Done");
    }

    public static void helloWorld2(int n, ExecutorService executorService) throws ExecutionException, InterruptedException {
        Future[] futures = new Future[n];
        for (int i = 0; i < n; ++i) {
            futures[i] = executorService.submit(() -> System.out.println("Hello World!"));
        }
        for (int i = 0; i < n; ++i) {
            futures[i].get();
        }
        System.out.println("Done");
    }

    public static void helloWorld3(int n, Executor executor) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(n);
        for (int i = 0; i < n; ++i) {
            executor.execute(() -> {
                System.out.println("Hello World!");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("Done");
    }

    public static void helloWorld4(int n, Executor executor) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(n);
        Thread currentThread = Thread.currentThread();
        for (int i = 0; i < n; ++i) {
            executor.execute(() -> {
                System.out.println("Hello World!");
                if (count.getAndDecrement() == 1) {
                    LockSupport.unpark(currentThread);
                }
            });
        }
        while (count.get() != 0) {
            LockSupport.park();
        }
        System.out.println("Done");
    }

    public static void helloWorld5(int n, ExecutorService executorService) throws ExecutionException {
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

        ExecutorService callbackPoll = Executors.newFixedThreadPool(8);


        List<ListenableFuture<String>> futures = Lists.newArrayList();
        for (int i = 0; i < n; i++) {
            ListenableFuture<String> submit = listeningExecutorService.submit(() -> {
                Thread.sleep(100000);
                return "Hello World!";
            });
            futures.add(submit);
        }
        final ListenableFuture<List<String>> listListenableFuture = Futures.successfulAsList(futures);
        listListenableFuture.addListener(() -> {
            System.out.println("done");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("休眠结束");
        }, callbackPoll);


        System.out.println("主线程结束");

    }

    public static void helloWorld55(int n, Executor executor)throws InterruptedException{

            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> System.out.println("hello world"), executor);
            CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> System.out.println("hello world"), executor);
            CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(() -> System.out.println("hello world"), executor);

        CompletableFuture<Void> res = CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture);
        res.whenCompleteAsync((voidd, throwable) -> {
            System.out.println("正常完成");
        }, executor);

        Thread.sleep(2000);
        System.out.println("done！！！");


    }
    public static void helloWorld6(int n, Executor executor) throws InterruptedException {
        ConcurrentInvoker invoker = new ConcurrentInvoker();
        for (int i = 0; i < n; ++i) {
            invoker.add(executor, () -> System.out.println("Hello World!"));
        }
        invoker.syncInvoke(Duration.ofMillis(100));
        System.out.println("Done");
    }



    public static void helloWorld7(int n, Executor executor) throws InterruptedException {
        ConcurrentInvoker invoker = new ConcurrentInvoker();
        for (int i = 0; i < n; ++i) {
            invoker.add(executor, () -> {System.out.println("Hello World!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
         ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Runnable callback = ConcurrentInvokers.timeoutListeningDecorator(() -> System.out.println("正常完成"), scheduledExecutorService, () -> System.out.println("timeout 处理逻辑!!!"), Duration.ofSeconds(1));
        invoker.asyncInvoke(executor, callback);

        // 为了正常显示
        Thread.sleep(4000);
        System.out.println("Done");
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(8);
        helloWorld55(10, threadPool);
        threadPool.shutdown();
    }

}
