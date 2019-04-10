package com.pr.rxj.observables.combine_observable.concatenation;

import io.reactivex.Observable;

public class CombineObservableByConcatMap {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alpha", "Beta" , "Gamma", "Delta", "Epsilon");
        Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");

        source.concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(s -> System.out.println("RECEVEID ->" + s));
    }
}
