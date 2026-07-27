// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description

package sliding.window;

public class LC_1493_LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int maxLength = -1;
        int currLength = 0;
        boolean zero = false;

        for (int i = 0; i < nums.length; i++) {
            currLength++;

            if (nums[i] == 0 && zero) {
                int start = i - currLength + 1;
                while (nums[start++] != 0) {
                    currLength--;
                }
                currLength--;
            } else if (nums[i] == 0) {
                zero = true;
            }

            maxLength = Math.max(maxLength, currLength - 1);
        }

        return maxLength;
    }
}
