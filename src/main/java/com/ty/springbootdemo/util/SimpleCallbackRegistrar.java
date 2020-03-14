package com.ty.springbootdemo.util;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public class SimpleCallbackRegistrar<T> {
    private Map<Consumer<T>, ExecutorService> callbacks = new HashMap<>();
    private T mLatestValue;
    private boolean mValueSet = false;

    public SimpleCallbackRegistrar() {
    }

    public T getLatestValue() {
        return this.mLatestValue;
    }

    public Consumer<T> register(Consumer<T> callback) {
        return this.register((ExecutorService) null, callback);
    }

    public Consumer<T> register(ExecutorService executorService, Consumer<T> callback) {
        if (callback == null) {
            return null;
        } else {
            this.callbacks.put(callback, executorService);
            if (this.mValueSet) {
                this.notifyCallback(callback, this.mLatestValue);
            }

            return callback;
        }
    }

    public void unRegister(Consumer<T> callback) {
        this.callbacks.remove(callback);
    }

    public void notifyCallbacks(T value) {
        this.mValueSet = true;
        this.mLatestValue = value;
        Optional.ofNullable(this.callbacks)
                .ifPresent(allCallbacks -> allCallbacks.keySet()
                        .forEach((tConsumer) -> this.notifyCallback(tConsumer, value))
                );
    }

    public void notifyCallbacksOnlyChanged(T value) {
        this.notifyCallbacksOnlyChanged(value, (Comparator) null);
    }

    public void notifyCallbacksOnlyChanged(T value, Comparator<T> comparator) {
        if (comparator != null) {
            if (comparator.compare(value, this.mLatestValue) == 0) {
                this.notifyCallbacks(value);
            }
        } else if (!Objects.equals(value, this.mLatestValue)) {
            this.notifyCallbacks(value);
        }

    }

    private void notifyCallback(final Consumer<T> callback, final T value) {
        Runnable runnable = () -> callback.accept(value);
        ExecutorService executorService = this.callbacks.get(callback);
        if (executorService != null) {
            executorService.submit(() -> {
                runnable.run();
            });
        } else {
            runnable.run();
        }

    }
}
