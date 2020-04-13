package com.kanez.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SingleThreadFuture {
    public static void main(String[] args) {
        Future<Integer> future =  new SquareCalculator().calculate(10);

        while(!future.isDone()) {
            System.out.println("Calculating...");
            try {
                Thread.sleep(300);
            }catch (InterruptedException e){

            }
        }

        try {
            Integer result = future.get();
            System.out.println("result: " + result);
        }catch (InterruptedException | ExecutionException e){

        }

    }
}
