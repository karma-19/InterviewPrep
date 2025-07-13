package src.ThreadsPractice.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreLockExample {
    //used for resources, like how many threads simultaneously can take database connection

    Semaphore semaphore = new Semaphore(2);

    int count = 0;

    public void incr() throws InterruptedException {
        semaphore.acquire();
        try {
            count++;
        } finally {
            semaphore.release();
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
