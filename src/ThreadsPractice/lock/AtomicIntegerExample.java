package src.ThreadsPractice.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void incr() {
        atomicInteger.incrementAndGet();
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void setAtomicInteger(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }
}
