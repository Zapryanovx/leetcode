# https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        self.sorted = []
        self.dfs(root)

        l = 0
        r = len(self.sorted) - 1

        while l < r:
            sum_of_pair = self.sorted[l] + self.sorted[r]
            if sum_of_pair == k:
                return True
            elif sum_of_pair < k:
                l += 1
            else:
                r -= 1

        return False

    def dfs(self, root):
        if root is None:
            return

        self.dfs(root.left)
        self.sorted.append(root.val)
        self.dfs(root.right)