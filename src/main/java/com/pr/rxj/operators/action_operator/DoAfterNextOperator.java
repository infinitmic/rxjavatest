package com.pr.rxj.operators.action_operator;

import io.reactivex.Observable;

public class DoAfterNextOperator {
    public static void main(String[] args) {
        // After emission
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doAfterNext(s-> System.out.println("Processed: " + s))
                .map(String::length)
                .subscribe(i-> System.out.println("Received: " + i));
    }
}
