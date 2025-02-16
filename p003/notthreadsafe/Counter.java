package p003.notthreadsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter{
    // Atomicなクラスを使用し、スレッドセーフにインクリメント処理を行いたい。
    private AtomicInteger count1 = new AtomicInteger(0);
    private AtomicInteger count2 = new AtomicInteger(0);

    public void increment() {
        // Atomicなフィールドを使って処理を行っているがこれはスレッドセーフではない。
        // count2.incrementGet() 実行中にcount1.incrementGet()が複数回行われると条件式が成り立たなくなる。
        int incCount1 = count1.incrementAndGet();
        if((count2.get() + 1) == incCount1){
            count2.incrementAndGet();
        }
    }

    public int[] getCount(){
        return new int[]{ this.count1.get(),this.count2.get() };
    }
}
