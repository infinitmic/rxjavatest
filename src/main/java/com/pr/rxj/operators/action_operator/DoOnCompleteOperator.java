package com.pr.rxj.operators.action_operator;

import io.reactivex.Observable;

public class DoOnCompleteOperator {

    public static void main(String[] args) {
        // Peek on each emission coming out of an operator and going to the next
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnComplete(()-> System.out.println("Source is done emitting: "))
                .map(String::length)
                .subscribe(i-> System.out.println("Received: " + i));
    }
}
