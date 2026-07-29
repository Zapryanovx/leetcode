// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description

package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            adj.get(edge[0]).add(new int[]{edge[1], 1});
            adj.get(edge[1]).add(new int[]{edge[0], 0});
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(adj, 0, visited);
    }

    private int dfs(List<List<int[]>> adj , int start, Set<Integer> visited) {
        visited.add(start);
        int cnt = 0;

        for (int[] pair : adj.get(start)) {
            int neighbour = pair[0];
            int direction = pair[1];

            if (!visited.contains(neighbour)) {
                cnt += direction + dfs(adj, neighbour, visited);
            }
        }

        return cnt;
    }
}
