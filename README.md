concurrent
summarize some common concurrent libraries

并发调用  ![https://github.com/fxd1/concurrent/blob/master/src/main/java/com/qunar/fxd/concurrent/ConcurrentInvoker.java]

> 场景：当需要对多个无关的异步调用的结果进行合并或归约时。这就好比我们自己组装电脑的情形：首先我们在不同商家订购不同的电脑配件，包括CPU、内存条、主板、机箱、显示器等，这就好比我们发起了多个无关的异步调用；当这些配件依次送达后，我们自己动手组装，这就可以类比为合并和规约的过程。 对于程序而言， 主线程 发起 A、B、C 等多个异步调用， 最终将三者的结果进行合并。会有两者情况，主线程阻塞等待最终合并结果，第二种，注册回调函数，等多个异步调用结束后执行callback逻辑

>> 对于第一种情况， 多个异步调用， 同步等待， 实现手段多种多样

1. 多个线程执行，最后将每一个线程进行thread.join()。 加入到主线程中，进而阻塞主线程，等待最终的结果

2. 利用countdonwlatch的await方法，进行阻塞

3. 自定义一个原理 Atmoic的计数器， 并且利用 LockSupport的 park、unpark方法进行阻塞 唤醒方法。计数器初始化 多个异步任务，每个任务执行完进行减1，并且判断是否唤醒， 主线程计数器 不为0，表示有任务未执行完，执行park。 相当于 自己实现了countdownlatch

4. 线程池 返回 一个契约 future， 然后 future,get进行操作

当前的操作，会不会 显得 很优雅，

```
 ConcurrentInvoker invoker = new ConcurrentInvoker();
        for (int i = 0; i < n; ++i) {
            invoker.add(executor, () -> System.out.println("Hello World!"));
        }
        invoker.syncInvoke(Duration.ofMillis(100));
        System.out.println("Done");
 ```
 
 
 
>> 对于 第二种， 多个异步调用， 通过回调实现最终合并

1. 使用 ListenableFuture ， 提交多个，通过Futures.successfulAsList(futures) 合并成一个 future， 注册监听 listener。

2. 使用CompletableFuture ，通过 allOf 或者 anyOf 合并成一个future，最终通过 whenCompleteAsync 等方法 进行回调

当前做法

```
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
        
        invoker.asyncInvoke(executor, ()-> System.out.println("callback"));
        
 ```
        
相比CompletableFuture， 没办法 进行批量，allOf可以传入对个，但是使用起来并不方法， 其次，当异步调用的任何一个线程执行时间过长，会导致最终对外接口的超时。 如果可以容忍舍弃超时的线程任务，或者有超时降级处理方案，以上两种都是无法支持的。 但是可以通过以下ConcurrentInvokers.timeoutListeningDecorator 进行装饰，增强callback功能，可以传入正常callback 和timeoutcallback。
```
ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Runnable callback = ConcurrentInvokers.timeoutListeningDecorator(() -> System.out.println("正常完成"), scheduledExecutorService, () -> System.out.println("timeout 处理逻辑!!!"), Duration.ofSeconds(1));
```
