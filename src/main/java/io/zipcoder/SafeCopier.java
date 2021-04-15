package io.zipcoder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    private final Lock lock = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {


        while (this.stringIterator.hasNext()) {
            lock.lock();
            try {
                if (this.stringIterator.hasNext()) {
                    String next = this.stringIterator.next();
                    //System.out.println(Thread.currentThread().getName() + ": " + next);
                    this.copied += next + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
               lock.unlock();
            }

        }


    }
}
