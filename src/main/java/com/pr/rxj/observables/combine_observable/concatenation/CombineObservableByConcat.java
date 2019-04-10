package com.pr.rxj.observables.combine_observable.concatenation;

import io.reactivex.Observable;

public class CombineObservableByConcat {

    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("Alpha", "Beta" , "Gamma", "Delta", "Epsilon");
        Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");

        Observable.concat(source1, source2)
                .subscribe(s -> System.out.println("RECEVEID ->" + s));
    }
}
