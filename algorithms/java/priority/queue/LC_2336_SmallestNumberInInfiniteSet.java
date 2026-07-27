// https://leetcode.com/problems/smallest-number-in-infinite-set/description

package priority.queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC_2336_SmallestNumberInInfiniteSet {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Set<Integer> removed = new HashSet<>();
    int next = 1;

    public LC_2336_SmallestNumberInInfiniteSet() {
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int toRemove = pq.poll();
            removed.add(toRemove);
            return toRemove;
        }

        removed.add(next);
        return next++;
    }

    public void addBack(int num) {
        if (removed.contains(num)) {
            removed.remove(num);
            pq.add(num);
        }
    }
}
