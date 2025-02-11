package p002.notthreadsafe;

public class Counter{
    private int count = 0;

    public int increment() {
        return count++;
    }

    public int getCount(){
        return count;
    }
}
