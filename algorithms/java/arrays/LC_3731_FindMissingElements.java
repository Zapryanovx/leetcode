// https://leetcode.com/problems/find-missing-elements/description

package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_3731_FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        boolean[] histogram = new boolean[max + 1];
        for (int n: nums) {
            histogram[n] = true;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!histogram[i]) {
                res.add(i);
            }
        }

        return res;
    }
}
