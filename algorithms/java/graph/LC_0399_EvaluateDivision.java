// https://leetcode.com/problems/evaluate-division/description

package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC_0399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adj = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            adj.computeIfAbsent(a, x -> new HashMap<>()).put(b, values[i]);
            adj.computeIfAbsent(b, x -> new HashMap<>()).put(a, 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            if (!adj.containsKey(from) || !adj.containsKey(to)) {
                res[i] = -1.0;
            } else {
                res[i] = dfs(adj, from, to, 1.0, new HashSet<>());
            }
        }

        return res;
    }

    private double dfs(Map<String, Map<String, Double>> adj, String from, String to,
                       double product, Set<String> visited) {
        if (from.equals(to)) {
            return product;
        }

        visited.add(from);

        for (Map.Entry<String, Double> e : adj.get(from).entrySet()) {
            String neighbour = e.getKey();
            if (!visited.contains(neighbour)) {
                double result = dfs(adj, neighbour, to, product * e.getValue(), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}
