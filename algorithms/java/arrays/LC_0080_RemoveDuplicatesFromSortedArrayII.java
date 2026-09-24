package arrays;

public class LC_0080_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int removed = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                if (cnt > 2) {
                    removed += cnt - 2;
                }
                cnt = 1;
            }

            nums[i - removed] = nums[i];
        }

        if (cnt > 2) {
            removed += cnt - 2;
        }
        
        return nums.length - removed;
    }
}
