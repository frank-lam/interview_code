package java_learn.concurrent.create_thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Created By Frank
 * @date 2018-08-10 17:44
 */
public class AtomaticDemo {
    private static AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(value.get());
        System.out.println(value.incrementAndGet());
    }
}
