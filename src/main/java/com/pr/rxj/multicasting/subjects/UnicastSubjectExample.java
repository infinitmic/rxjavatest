package com.pr.rxj.multicasting.subjects;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class UnicastSubjectExample {
    public static void main(String[] args) {

        Subject<String> subject = UnicastSubject.create();

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> (l+1)*300 + " milliseconds")
                .subscribe(subject);

        sleep(2000);

        subject.subscribe(s -> System.out.println("Observer1 : " + s));

        sleep(2000);

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
