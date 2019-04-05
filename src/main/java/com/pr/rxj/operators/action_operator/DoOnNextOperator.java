package com.pr.rxj.operators.action_operator;

import io.reactivex.Observable;

public class DoOnNextOperator {

    public static void main(String[] args) {
        // Peek on each emission coming out of an operator and going to the next
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnNext(s-> System.out.println("Processing: " + s))
                .map(String::length)
                .subscribe(i-> System.out.println("Received: " + i));
    }
}
