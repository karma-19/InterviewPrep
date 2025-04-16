package ThreadsPractice;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExample {
    public static void main(String[] args) {
        AtomicInteger at = new AtomicInteger();
        at.set(0);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=20; i++) {
                    while(at.get() != 0) {

                    }
                    if(i%2==0)
                    System.out.println(i + " ");

                    at.set(1);
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i=21; i<=40; i++) {
                    while(at.get() != 1) {

                    }
                    if(i%2==1)
                    System.out.println(i + " ");
                    at.set(0);
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch ( Exception e) {
            
        }
    }
}
