package com.pr.rxj.multicasting.subjects;

import io.reactivex.Observable;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class UnicastSubjectExampleMoreThanOneObserver {
    public static void main(String[] args) {

        Subject<String> subject = UnicastSubject.create();

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> (l+1)*300 + " milliseconds")
                .subscribe(subject);

        sleep(2000);

        //Multicast to support multiple observers
        Observable<String> multicast = subject.publish().autoConnect();


        //Bring in the first observer
        multicast.subscribe(s -> System.out.println("Observer 1: " + s));

        sleep(2000);

        //Bring in the second observer
        multicast.subscribe(s -> System.out.println("Observer 2: " + s));

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
