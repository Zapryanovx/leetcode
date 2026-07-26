// https://leetcode.com/problems/cousins-in-binary-tree/description

package binary.trees;

public class LC_0993_CousinsInBinaryTree {
    private int xParent = -1;
    private int xDepth = 0;
    private int yParent = -1;
    private int yDepth = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, -1, 0, x, y);
        return xParent != yParent && xDepth == yDepth;
    }

    private void dfs(TreeNode root, int prev, int depth, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            xParent = prev;
            xDepth = depth;
        } else if (root.val == y) {
            yParent = prev;
            yDepth = depth;
        }

        dfs(root.left, root.val, depth + 1, x, y);
        dfs(root.right, root.val, depth + 1, x, y);
    }
}
