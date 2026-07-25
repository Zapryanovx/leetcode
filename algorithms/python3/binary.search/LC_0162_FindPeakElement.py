# https://leetcode.com/problems/find-peak-element/description

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0

        l = 0
        r = len(nums) - 1

        while l <= r:
            m = (l + r) // 2

            left = nums[m - 1] if m > 0 else float('-inf')
            right = nums[m + 1] if m < len(nums) - 1 else float('-inf')

            if nums[m] > left and nums[m] > right:
                return m
            elif nums[m] < right:
                l = m + 1
            else:
                r = m - 1

        return l