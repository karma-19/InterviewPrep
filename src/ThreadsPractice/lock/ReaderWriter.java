package src.ThreadsPractice.lock;
/*Allow multiple readers at the same time if no writer is writing.

Only one writer can write at a time and no reader should read during writing.

 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriter {
    int sharedData = 0;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public int read() {
        readLock.lock();
        try {
            System.out.println("Thread:" + Thread.currentThread().getName() + " Reading... Data: " + sharedData);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return sharedData;
        } finally {
            readLock.unlock();
        }
    }

    public void write(int newData) {
        writeLock.lock();
        try {
            System.out.println("Thread:" + Thread.currentThread().getName() + " Writing... Data: " + newData);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.sharedData = newData;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return sharedData;
        } finally {
            readLock.unlock();
        }
    }

    public void setSharedData(int sharedData) {
        writeLock.lock();
        try {
            this.sharedData = sharedData;
        } finally {
            writeLock.unlock();
        }
    }
}
