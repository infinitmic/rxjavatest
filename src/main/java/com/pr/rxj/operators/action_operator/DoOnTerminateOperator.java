package com.pr.rxj.operators.action_operator;

import io.reactivex.Observable;

public class DoOnTerminateOperator {
    public static void main(String[] args) {
        // Peek on each emission coming out of an operator and going to the next
        Observable.just(5,2,4,0,3,2,8)
                .doOnError(e-> System.out.println("Source failed!"))
                .map(i-> 10/i)
                .doOnError(e-> System.out.println("Division Failed!"))
                .doOnTerminate(() -> {System.out.println("Emission will terminate now!");})
                .subscribe(i-> System.out.println("Received: " + i), e -> System.out.println("RECEIVED ERROR: " + e));


    }
}
