package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class LC_0380_InsertDeleteGetRandomO1 {
    private final List<Integer> l;
    private final Map<Integer, Integer> m;

    public LC_0380_InsertDeleteGetRandomO1() {
        l = new ArrayList<>();
        m = new HashMap<>();
    }

    public boolean insert(int val) {
        if (m.containsKey(val)) {
            return false;
        }

        m.put(val, l.size());
        l.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!m.containsKey(val)) {
            return false;
        }

        int indexToRemove = m.get(val);
        int lastElement = l.get(l.size() - 1);

        l.set(indexToRemove, lastElement);
        m.put(lastElement, indexToRemove);

        l.remove(l.size() - 1);
        m.remove(val);

        return true;
    }

    public int getRandom() {
        int random = ThreadLocalRandom.current().nextInt(l.size());
        return l.get(random);
    }
}
