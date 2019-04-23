package com.pr.rxj.concurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ObserveOnNuance2 {
    public static void main(String[] args) {
        Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO", "232352/5675675/FOXTROT")
                .subscribeOn(Schedulers.io()) // Happens on io
                .flatMap(s -> Observable.fromArray(s.split("/")))
                .doOnNext(s -> System.out.println("Split out " + s + " on thread " + Thread.currentThread().getName()))

                //Happens on computation
                .observeOn(Schedulers.computation())
                .filter( s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .reduce((total, next) -> total + next)
                .doOnSuccess(s -> System.out.println("Calculated sum " + s + " on thread " + Thread.currentThread().getName()))

                //switch back to io
                .observeOn(Schedulers.io())
                .map(i -> i.toString())
                .doOnSuccess(s -> System.out.println("Writing sum " + s + " to a file on thread " + Thread.currentThread().getName()))
                .subscribe(s -> write(s, "/home/raj/Desktop/output.txt"));

        sleep(1000);
    }

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void write(String text, String path) {
        BufferedWriter writer = null;
        try {
            //Create a temporary file
            File file = new File(path);
            writer = new BufferedWriter(new FileWriter(file));
            writer.append(text);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e){

            }
        }
    }
}
