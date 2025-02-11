package p001.threadsafe;

public class ForClass extends Thread {
    public int count = 5;

    /**
     * Threadクラスのオーバライドメソッド
     * countの回数分0.5秒ごとに「並行処理中...」を出力する。
     */
    @Override
    public void run() {
        // 公開されている可変なステートは使用しない。
        int limit = 5;
        for (int i = 0; i < limit; i++) {
            try {
                System.out.println((i + 1) + "回目の並行処理中...");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("割り込み例外発生");
            }
        }
    }
}
