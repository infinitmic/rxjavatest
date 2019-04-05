package com.pr.rxj.operators.action_operator;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DoOnEachOperator {
    public static void main(String[] args) {
        // Peek on each emission coming out of an operator and going to the next
        Observable.just(5,2,4,5,3,2,8)
                .doOnEach(s -> System.out.println("Event occurred"))
                .doOnEach(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onEach Emission -> Source subscribed!");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onEach Emission -> On Next occurred !");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onEach Emission -> On Error occurred !");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onEach Emission -> On Complete occurred !");
                    }
                })
                .doOnError(e-> System.out.println("Source failed!"))
                .map(i-> 10/i)
                .doOnError(e-> System.out.println("Division Failed!"))
                .subscribe(i-> System.out.println("Received: " + i), e -> System.out.println("RECEIVED ERROR: " + e));


    }
}
