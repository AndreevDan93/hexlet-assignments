package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String,Integer> getMinMax(int[] array) {
        MaxThread maxThread = new MaxThread(array);
        MinThread minThread = new MinThread(array);

        maxThread.start();
        minThread.start();

        try {
            minThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }


        try {
            maxThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        int max = maxThread.getMax();
        int min = minThread.getMin();

        Map<String, Integer> map = new HashMap<>();
        map.put("max", max);
        map.put("min", min);

        return map;
    }
    // END
}
