package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private int[] arr;
    private int min;

    public MinThread(int[] arr) {
        this.arr = arr;
    }

    public int getMin() {
        return min;
    }

    @Override
    public void run() {
        this.min = Arrays.stream(arr).min().orElseThrow();
    }
}
// END
