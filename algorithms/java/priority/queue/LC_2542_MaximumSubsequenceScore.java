// https://leetcode.com/problems/maximum-subsequence-score/description

package priority.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_2542_MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;
        for (int i = 0; i < pairs.length; i++) {
            pq.add(pairs[i][0]);
            sum += pairs[i][0];

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                maxScore = Math.max(maxScore, sum * pairs[i][1]);
            }
        }

        return maxScore;
    }
}
