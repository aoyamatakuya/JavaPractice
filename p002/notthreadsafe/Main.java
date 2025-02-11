package p002.notthreadsafe;

public class Main {
    public static void main(String[] args){
        Counter counter = new Counter();

        // RunnableはFunctionalInterface(1つの抽象メソッドしか持たない)なのでラムダ式が使用可能
        Runnable task = () -> {
            for(int i=0; i<10000; i++){
                counter.increment();
            }
        };

        // スレッドを2つ作成
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        // 並列処理実行
        thread1.start();
        thread2.start();
        try{
            // 各スレッドの処理が終わるのを待つ
            thread1.join();
            thread2.join();
        }catch (InterruptedException ex){}

        // 実行結果を出力(期待する結果は20000)
        System.out.println("結果：" + counter.getCount());
    }
}
