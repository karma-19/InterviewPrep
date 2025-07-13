package src.ThreadsPractice.lock;

public class SynchronizedBlockExample {
    // inbuilt in java
    int count = 0;

    public synchronized void incr() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
