// https://leetcode.com/problems/find-if-path-exists-in-graph/description

package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_1971_FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (var edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(source);

        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        while (!dq.isEmpty()) {
            int current = dq.removeFirst();

            if (current == destination) {
                return true;
            }

            for (int neighbour: adj.get(current)) {
                if (!visited.contains(neighbour)) {
                    dq.addLast(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return false;
    }
}
