package com.pr.rxj.observables.create_observable;

import io.reactivex.Observable;

public class GetObservableByRange {
    public static void main(String[] args) {
        Observable.range(1,10)
                .subscribe(s-> System.out.println("RECEIVED: " + s));
    }
}
