package com.wangn.rxjava;

import static io.reactivex.Observable.*;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-11
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        Disposable disposable = Observable.just("wang")
                .map(v -> String.format("this word is %s", v))
                .subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.newThread())
                .observeOn(Schedulers.from(Executors.newSingleThreadExecutor(runnable -> new Thread(runnable, "myThread"))))
                .subscribe(s -> {
                    System.out.println(Thread.currentThread().getName() + ":" + s);
                });
        System.out.println(Thread.currentThread().getName() + ":main");
        System.out.println(disposable.isDisposed());
        Thread.sleep(100);
        System.out.println(disposable.isDisposed());
    }

    @Test
    public void testFrom() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor(r -> new Thread(r, "future task run task"));
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000);
            return "hahha";
        });
        Observable.fromFuture(future)
                .observeOn(Schedulers.newThread())
                .subscribe(s -> {
                    System.out.println(Thread.currentThread().getName());
                });
        Thread.sleep(1000);
        System.out.println("Task up");
        Thread.sleep(3000);
    }

    @Test
    public void testTimer() throws InterruptedException {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
        Thread.sleep(3000);
    }

    @Test
    public void testInterval() throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(x -> {
                    System.out.println(x + "你说啥");
                });
        Thread.sleep(8 * 1000);
    }

    @Test
    public void testMerge() throws InterruptedException {
        merge(
            timer(500, TimeUnit.MILLISECONDS),
            timer(500, TimeUnit.MILLISECONDS),
            timer(500, TimeUnit.MILLISECONDS),
            timer(500, TimeUnit.MILLISECONDS)
        ).subscribe(System.out::println);

        Thread.sleep(4000);
    }

    @Test
    public void testConcat() throws InterruptedException {
        concat(
            timer(500, TimeUnit.MILLISECONDS),
            timer(500, TimeUnit.MILLISECONDS),
            timer(500, TimeUnit.MILLISECONDS),
            timer(500, TimeUnit.MILLISECONDS)
        ).subscribe(System.out::println);

        Thread.sleep(4000);
    }
}
