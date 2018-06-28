package com.wangn.rxjava.mywork;

import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.stream.LongStream;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-27
 */
public class RepeatObservable<T> extends Observable<T> {

    private T item;

    private long times;

    public RepeatObservable(T item, long times) {
        this.item = item;
        this.times = times;
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        LongStream.range(0, times + 1)
                .mapToObj(i -> this.item)
                .forEach(observer::onNext);
        observer.onComplete();
    }
}
