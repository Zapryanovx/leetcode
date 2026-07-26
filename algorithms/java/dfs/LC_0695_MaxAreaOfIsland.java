// https://leetcode.com/problems/max-area-of-island/description

package dfs;

public class LC_0695_MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxLength = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxLength = Math.max(maxLength, dfs(grid, i, j));
                }
            }
        }

        return maxLength;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return 0;
        } else if (j < 0 || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        return 1
                + dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j - 1)
                + dfs(grid, i, j + 1);
    }
}
