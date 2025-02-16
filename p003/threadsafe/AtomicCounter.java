package p003.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter{
    // Atomicなクラスを使用し、スレッドセーフにインクリメント処理を行いたい。
    private AtomicInteger count1 = new AtomicInteger(0);
    private AtomicInteger count2 = new AtomicInteger(0);

    public int[] getCount(){
        return new int[]{ this.count1.get(),this.count2.get() };
    }

    public void increment() {
        // Atomicなフィールドを使っているがcount2.incrementGet() 実行中にcount1.incrementGet()が複数回行われると条件式が成り立たなくなる。
        // なのでsynchronizedで一連の処理が終わるまでは、これらの変数に他スレッドがアクセスできないようロックする。
        synchronized (this){
            int incCount1 = count1.incrementAndGet();
            if((count2.get() + 1) == incCount1){
                count2.incrementAndGet();
            }
        }
    }
}
