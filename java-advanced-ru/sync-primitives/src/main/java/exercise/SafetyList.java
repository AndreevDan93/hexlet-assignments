package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    // BEGIN
    private final List<Integer> list = new ArrayList<>();

    public synchronized void add(int i) {
        this.list.add(i);
    }

    public int get(int index) {
        return this.list.get(index);
    }

    public int getSize() {
        return this.list.size();
    }
    // END
}
