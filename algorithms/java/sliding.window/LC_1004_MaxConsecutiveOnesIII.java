// https://leetcode.com/problems/max-consecutive-ones-iii/description

package sliding.window;

public class LC_1004_MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int currLength = 0;
        int maxLength = -1;
        int zeros = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
            currLength++;

            if (zeros > k) {
                int start = i - currLength + 1;
                while (nums[start++] != 0) {
                    currLength--;
                }
                currLength--;
                zeros--;
            }

            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }
}
