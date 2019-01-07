package com.qunar.fxd.concurrent;

import com.google.common.base.Preconditions;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ConcurrentInvoker {
    private ArrayList<Consumer<Breakpoint>> snips = new ArrayList<>();

    public boolean syncInvoke(Duration timeout) {
        Preconditions.checkNotNull(timeout);
        DisposableBlocker blocker = new DisposableBlocker();
        Instant deadline = Instant.now().plus(timeout);
        invoke(blocker::resume);
        return blocker.blockUntil(deadline);
    }

    /**
     *avoid blocking forever, causing thread exhausted or program crashes
     *
     */
    @Deprecated
    public void syncInvoke() {
        DisposableBlocker blocker = new DisposableBlocker();
        invoke(blocker::resume);
        blocker.block();
    }


    public void asyncInvoke(Executor executor, Runnable callback) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(callback);
        invoke(() -> executor.execute(callback));
    }



    public void invoke(Runnable callback) {
        Preconditions.checkNotNull(callback);
        if (snips.isEmpty()) {
            callback.run();
        }
        Breakpoint breakpoint = new Breakpoint(snips.size(), callback);
        call(breakpoint);
    }

    public void addAll(Executor executor, Collection<Runnable> tasks) {
        Preconditions.checkNotNull(tasks);
        for (Runnable task: tasks) {
            add(executor, task);
        }
    }

    private void add(Consumer<Breakpoint> snip) {
        Preconditions.checkNotNull(snips);
        snips.add(snip);
    }

    public void add(Executor executor, Runnable task) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(task);
        add(breakpoint -> {
            try {
                executor.execute(() -> {
                    try {
                        task.run();
                    } finally {
                        breakpoint.join();
                    }
                });
            } catch (Throwable t) {
                breakpoint.join();
                throw t;
            }
        });
    }

    private void call(Breakpoint breakpoint) {
        for (Consumer<Breakpoint> snip : snips) {
            snip.accept(breakpoint);
        }
    }



    private static final class Breakpoint {
        private final AtomicInteger count;
        private final Runnable callback;

        private Breakpoint(int count, Runnable callback) {
            this.count = new AtomicInteger(count);
            this.callback = callback;
        }

        public void join() {
            if (count.getAndDecrement() == 1) {
                callback.run();
            }
        }
    }
}
