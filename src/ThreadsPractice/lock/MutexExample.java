package src.ThreadsPractice.lock;

public class MutexExample {
    int count = 0;
    int lock = 0;

    public void incr() {
        while(lock==1) {
            Thread.yield(); // be a bit nicer to cpu
        }
        lock = 1;
        count++;
        lock = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }
}
