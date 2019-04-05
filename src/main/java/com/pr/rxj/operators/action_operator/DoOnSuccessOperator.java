package com.pr.rxj.operators.action_operator;

import io.reactivex.Observable;

public class DoOnSuccessOperator {
    public static void main(String[] args) {
        Observable.just(5,3,7,10,2,14)
                .reduce((total , next) -> total + next)
                .doOnSuccess(i -> System.out.println("On Success"))
                .subscribe(i -> System.out.println("RECEVIED " + i));

    }
}
