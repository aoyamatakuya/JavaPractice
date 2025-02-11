package p002.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    // Atomicなクラスを使用し、スレッドセーフにインクリメント処理を行う。
    private AtomicInteger count = new AtomicInteger(0);

    public int increment() {
        return count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }
}
