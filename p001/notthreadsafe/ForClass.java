package p001.notthreadsafe;
import java.lang.Thread;

public class ForClass extends Thread{
    public int count = 5;

    /**
     * Threadクラスのオーバライドメソッド
     * countの回数分0.5秒ごとに「並行処理中...」を出力する。
     */
    @Override
    public void run(){
        int limit = this.count;
        for(int i = 0; i < limit; i++){
            try{
                System.out.println((i + 1) + "回目の並行処理中...");
                Thread.sleep(500);
            }catch (InterruptedException ex){
                System.out.println("割り込み例外発生");
            }
        }
    }
}
