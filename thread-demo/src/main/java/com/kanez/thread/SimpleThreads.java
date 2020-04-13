package com.kanez.thread;

public class SimpleThreads {

    private static class Task implements Runnable{

        public void run() {
            System.out.println("This is thread:" + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println("exception： " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Task());
        thread.start();
        System.out.println("Start a new thread:");
//        while(thread.isAlive()){
//            System.out.println("waiting...");
//            thread.join(1000);
//        }
//        System.out.println("Thread is finish.");
        System.out.println("start to wait..");
        thread.join(10000);
        System.out.println("finish waiting...");
        System.out.println("Thread alive? : " + thread.isAlive());
    }
}
