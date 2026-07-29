// https://leetcode.com/problems/total-cost-to-hire-k-workers/description

package priority.queue;

import java.util.PriorityQueue;

public class LC_2462_TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int i = 0;
        int j = costs.length - 1;
        while (i < candidates && i <= j) {
            left.add(costs[i++]);
        }
        while (j >= costs.length - candidates && j >= i) {
            right.add(costs[j--]);
        }

        int sessions = k;
        long totalCost = 0;
        while (sessions-- > 0) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                totalCost += left.poll();
                if (i <= j) {
                    left.add(costs[i++]);
                }
            } else {
                totalCost += right.poll();
                if (i <= j) {
                    right.add(costs[j--]);
                }
            }
        }

        return totalCost;
    }
}
