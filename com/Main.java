package com;

public class Main {

    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread myFirstThread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("Hold object 1");
                    synchronized (object1) {
                        Thread.sleep(1000);
                        System.out.println("Hold object 2");
                        synchronized (object2) {
                            System.out.println("Inside object 2");
                        }
                    }
                } catch (InterruptedException e) {}
            }
        });


        Thread mySecondThread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("Hold object 2");
                    synchronized (object2) {
                        Thread.sleep(1000);
                        System.out.println("Hold object 1");
                        synchronized (object1) {
                            System.out.println("Inside object 1");
                        }
                    }
                } catch (InterruptedException e) {}
            }
        });


        myFirstThread.start();
        myFirstThread.join();

        mySecondThread.start();
        mySecondThread.join();
    }
}
