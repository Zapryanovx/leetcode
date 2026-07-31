// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description

package greedy;

import java.util.Arrays;

public class LC_0452_MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int cnt = 0;
        int start = 0;
        int end = 1;

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int max = points[start][0];
        int min = points[start][1];

        while (end < points.length) {
            if (points[end][0] >= max && points[end][0] <= min) {
                max = Math.max(max, points[end][0]);
                min = Math.min(min, points[end][1]);
                end++;
            } else {
                cnt++;
                start = end;
                end++;
                max = points[start][0];
                min = points[start][1];
            }
        }

        return cnt + 1;
    }
}
