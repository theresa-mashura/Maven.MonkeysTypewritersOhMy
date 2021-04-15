package io.zipcoder;

import static java.lang.Thread.sleep;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while (this.stringIterator.hasNext()) {

            try {
                sleep(500);
                if (this.stringIterator.hasNext()) {
                    String next = this.stringIterator.next();
                    //System.out.println(Thread.currentThread().getName() + ": " + next);
                    this.copied += next + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
