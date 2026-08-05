// https://leetcode.com/problems/remove-methods-from-project/description

package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC_3310_RemoveMethodsFromProject {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (var e: invocations) {
            edges.get(e[0]).add(e[1]);
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.add(k);
        Set<Integer> suspicious = new HashSet<>();
        suspicious.add(k);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.pollFirst();
                for (int nbr: edges.get(curr)) {
                    if (!suspicious.contains(nbr)) {
                        suspicious.add(nbr);
                        q.add(nbr);
                    }
                }
            }
        }

        boolean canRemove = true;
        for (var e: invocations) {
            if (!suspicious.contains(e[0]) && suspicious.contains(e[1])) {
                canRemove = false;
                break;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (canRemove && suspicious.contains(i)) {
                continue;
            }
            res.add(i);
        }

        return res;
    }
}
