package com.pr.rxj.observables.combine_observable.zipping;

import io.reactivex.Observable;

public class CombineObservableByZip {

    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("Alpha", "Beta" , "Gamma", "Delta", "Epsilon");
        Observable<String> source2 = Observable.just("Zeta", "Eta", "Theta");

        Observable.zip(source1, source2, (s, i) -> s + "-" + i)
                .subscribe(s -> System.out.println("RECEVEID ->" + s));
    }
}
