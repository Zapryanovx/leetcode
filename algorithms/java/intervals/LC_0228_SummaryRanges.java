package intervals;

import java.util.ArrayList;
import java.util.List;

public class LC_0228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }

        List<String> intervals = new ArrayList<>();
        int start = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 < nums[i + 1]) {
                if (start == i) {
                    intervals.add(String.valueOf(nums[i]));
                } else {
                    intervals.add(nums[start] + "->" + nums[i]);
                }
                start = i + 1;
            }
        }

        if (start == nums.length - 1) {
            intervals.add(String.valueOf(nums[nums.length - 1]));
        } else {
            intervals.add(nums[start] + "->" + nums[nums.length - 1]);
        }

        return intervals;
    }
}
