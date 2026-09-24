// https://leetcode.com/problems/stone-game-ii/description

package dp;

public class LC_1140_StoneGameII {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i +  1];
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                for (int x = 1; x <= Math.min(2 * m, n - i); x++) {
                    dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                }
            }
        }

        return dp[0][1];
    }
}
