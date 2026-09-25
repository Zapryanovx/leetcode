package intervals;

import java.util.Arrays;

public class LC_0057_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        int at = 0;
        boolean inserted = false;

        for (int i = 0; i < intervals.length; i++) {
            if (!inserted && newInterval[0] <= intervals[i][1]) {
                int start = Math.min(newInterval[0], intervals[i][0]);
                int end = newInterval[1];

                while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
                    end = Math.max(newInterval[1], intervals[i][1]);
                    i++;
                }

                i--;
                result[at++] = new int[]{start, end};
                inserted = true;
            } else {
                result[at++] = intervals[i];
            }
        }

        if (!inserted) {
            result[at++] = newInterval;
        }

        return Arrays.copyOf(result, at);
    }
}
