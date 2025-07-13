package src.ThreadsPractice.lock;

import java.time.Instant;

public class Main {
    //1. atomic Integer
    //2. synchronized block
    //3. Mutex
    //4. Semaphore
    //5. Returrant
    //6. problems :
    /*

    1. Dining Philosophers Problem
Scenario: 5 philosophers sit around a table with 5 forks. To eat, a philosopher needs both the left and right fork.

Concepts: Deadlock, resource sharing, starvation, mutexes, semaphores.

Challenge: Prevent deadlock and ensure fairness.

2. Producer-Consumer Problem (Bounded Buffer)
Scenario: A producer generates data and places it in a buffer; the consumer takes it from the buffer.

Concepts: Synchronization, condition variables, mutexes, semaphores.

Challenge: Ensure the producer doesn’t overflow the buffer and the consumer doesn’t consume from an empty buffer.

3. Readers-Writers Problem
Scenario: Many reader threads can read from shared memory, but writer threads need exclusive access.

Concepts: Reader-writer locks, mutual exclusion, starvation.

Challenge: Avoid starvation of either readers or writers.

4. Sleeping Barber Problem
Scenario: A barber sleeps if there are no customers. If a customer comes in while the barber is busy, they wait. If the waiting room is full, they leave.

Concepts: Semaphore, condition variables.

Challenge: Manage waiting room and synchronization between barber and customers.

5. Cigarette Smokers Problem
Scenario: An agent places two random ingredients on the table. Three smokers each have one of the three ingredients and need the other two to make a cigarette.

Concepts: Coordination, semaphores.

Challenge: Correctly synchronize access to the table and prevent deadlock.

6. The Elevator (Lift) Problem
Scenario: Multiple people call the elevator from different floors. The elevator needs to manage direction and pick-up/drop-off efficiently.

Concepts: Scheduling, concurrency, fairness.

Challenge: Optimize elevator algorithm (e.g., SCAN, LOOK) under concurrency.

7. The Sleeping Teaching Assistant Problem
Scenario: A TA sleeps until students need help. Students wait outside if the TA is busy or the office is full.

Concepts: Very similar to the sleeping barber, but often used in OS classes.

8. Bounded Buffer Ring Queue Problem
Scenario: A buffer of limited size shared between multiple producers and consumers.

Concepts: Circular queue, semaphores, locks.

Challenge: Manage wrapping around the ring and synchronization.

9. Traffic Intersection Problem
Scenario: Multiple cars approach an intersection from all sides. They must avoid crashing while optimizing flow.

Concepts: Mutexes, resource allocation.

Challenge: Avoid deadlock and starvation, especially with one-lane intersections.

10. Banker's Algorithm (Deadlock Avoidance)
Scenario: Multiple processes request resources. The system must ensure it stays in a safe state.

Concepts: Resource allocation, deadlock avoidance, safe/unsafe states.

Challenge: Implement the Banker's algorithm to evaluate resource requests.


     */

    public static void main(String[] args) throws InterruptedException {
//        callForAtomicInteger();
//        callForSynchronizedBlock();
//        callForMutexLock();
//        callForSemaphoreLock();
//        callForReentrantLock();
        callForReaderWriter();

    }

    public static void callForReaderWriter() throws InterruptedException {
        ReaderWriter readerWriter = new ReaderWriter();
/*        Runnable runnable1 = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                int readValue = readerWriter.read();
                System.out.println("Thread: " + Thread.currentThread().getName() + " Read: " + readValue);
                readerWriter.write(readValue + 1);
            }
        };

        Runnable runnable2 = () -> {
            for (int i = 0; i < 10; i++) {
                int readValue = readerWriter.read();
                System.out.println("Thread: " + Thread.currentThread().getName() + " Read: " + readValue);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                readerWriter.write(readValue + 1);
            }
        };

 */
        // Multiple readers
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    readerWriter.read();
                }
            }).start();
        }

        // Writers
        for (int i = 0; i < 20; i++) {
            int writeValue = i;
            new Thread(() -> {
                try {
                    readerWriter.write(writeValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        /*

        Thread t1 = new Thread(runnable1, "firstThread:");
        Thread t2 = new Thread(runnable2, "secondThread");

        long start = Instant.now().getEpochSecond();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = Instant.now().getEpochSecond();

         */

//        System.out.println("Call for readerWriter lock: " + readerWriter.getCount() + ". Time taken : " + (end-start) + "ms");
    }

    public static void callForReentrantLock() throws InterruptedException {
        ReturrantLockExample returrantLockExample = new ReturrantLockExample();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    returrantLockExample.incr();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    returrantLockExample.incr();
                }
            }
        };

        Thread t1 = new Thread(runnable1, "firstThread:");
        Thread t2 = new Thread(runnable2, "secondThread");

        long start = Instant.now().getEpochSecond();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = Instant.now().getEpochSecond();

        System.out.println("Call for reentrant lock: " + returrantLockExample.getCount() + ". Time taken : " + (end-start) + "ms");
    }


    public static void callForSemaphoreLock() throws InterruptedException {
        SemaphoreLockExample semaphoreLockExample = new SemaphoreLockExample();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        semaphoreLockExample.incr();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    try {
                        semaphoreLockExample.incr();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable1, "firstThread:");
        Thread t2 = new Thread(runnable2, "secondThread");

        long start = Instant.now().getEpochSecond();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = Instant.now().getEpochSecond();

        System.out.println("Call for semaphore lock: " + semaphoreLockExample.getCount() + ". Time taken : " + (end-start) + "ms");
    }


    public static void callForMutexLock() throws InterruptedException {
        MutexExample mutexExample = new MutexExample();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + mutexExample.getLock());
                    mutexExample.incr();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + mutexExample.getLock());
                    mutexExample.incr();
                }
            }
        };

        Thread t1 = new Thread(runnable1, "firstThread:");
        Thread t2 = new Thread(runnable2, "secondThread");

        long start = Instant.now().getEpochSecond();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = Instant.now().getEpochSecond();

        System.out.println("Call for mutex lock: " + mutexExample.getCount() + ". Time taken : " + (end-start) + "ms");
    }

    public static void callForSynchronizedBlock() throws InterruptedException {
        SynchronizedBlockExample synchronizedBlockExample = new SynchronizedBlockExample();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    synchronizedBlockExample.incr();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    synchronizedBlockExample.incr();
                }
            }
        };

        Thread t1 = new Thread(runnable1, "firstThread:");
        Thread t2 = new Thread(runnable2, "secondThread");

        long start = Instant.now().getEpochSecond();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = Instant.now().getEpochSecond();

        System.out.println("Call for synchronized block: " + synchronizedBlockExample.getCount() + ". Time taken : " + (end-start) + "ms");
    }

    public static void callForAtomicInteger() throws InterruptedException {
        //atomic Integer
        AtomicIntegerExample  atomicIntegerExample = new AtomicIntegerExample();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    atomicIntegerExample.incr();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<500; i++) {
                    atomicIntegerExample.incr();
                }
            }
        };

        Thread t1 = new Thread(runnable1, "firstThread:");
        Thread t2 = new Thread(runnable2, "secondThread");

        long start = Instant.now().getEpochSecond();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = Instant.now().getEpochSecond();
        System.out.println("Call for atomic integer: " + atomicIntegerExample.getAtomicInteger().get()+ ". Time taken : " + (end-start) + "ms");
    }

}
