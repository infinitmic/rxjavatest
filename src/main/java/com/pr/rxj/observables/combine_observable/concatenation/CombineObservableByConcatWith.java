package com.pr.rxj.observables.combine_observable.concatenation;

import io.reactivex.Observable;

public class CombineObservableByConcatWith {

    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("Alpha", "Beta" , "Gamma", "Delta", "Epsilon");
        Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");

        source1.concatWith(source2)
                .subscribe(s -> System.out.println("RECEVEID ->" + s));
    }
}
