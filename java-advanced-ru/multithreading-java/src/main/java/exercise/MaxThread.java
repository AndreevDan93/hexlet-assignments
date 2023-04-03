package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {
    private int[] arr;
    private int max;

    public MaxThread(int[] arr) {
        this.arr = arr;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        this.max = Arrays.stream(arr).max().getAsInt();
    }
}
// END
