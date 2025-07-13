package src.ThreadsPractice.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReturrantLockExample {
    ReentrantLock reentrantLock = new ReentrantLock();

    int count = 0;

    public void incr() {
        reentrantLock.lock();
        try {
            count++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /*
    When Thread A acquires the lock the first time, the lock records:

"Thread A owns me."

"Acquisition count = 1"

If Thread A tries to lock it again, the lock checks:

"Is this the same thread that already owns me?"

✅ Yes? Then it increments the count instead of blocking.

Acquisition count becomes 2, 3, etc.

The lock is only fully released when the thread calls unlock() the same number of times it called lock().
     */

    /*
    🔁 Difference from synchronized
Feature	synchronized	ReentrantLock
Reentrant	✅ Yes	✅ Yes
Try lock with timeout	❌ No	✅ Yes (tryLock())
Interruptible lock	❌ No	✅ Yes
Fairness option	❌ No	✅ Yes (new ReentrantLock(true))
Manual unlock	❌ No (auto-release)	✅ Yes (must call unlock())
     */
}
