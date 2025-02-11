package p001.threadsafe;

public class Main {
    public static void main(String[] args){
        ForClass forClass = new ForClass();
        System.out.println("並列処理実行");
        forClass.start();
        System.out.println("上限変更");
        forClass.count = 3;
    }
}
