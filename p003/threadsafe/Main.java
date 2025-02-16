package p003.threadsafe;

public class Main {
    public static void main(String[] args){
        AtomicCounter counter = new AtomicCounter();

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

        // 実行結果を出力(期待する結果は count1・2 ともに20000)
        int[] resArr = counter.getCount();
        for(int i=0; i<resArr.length; i++){
            System.out.println("結果" + (i + 1) + "番目：" + resArr[i]);
        }
    }
}
