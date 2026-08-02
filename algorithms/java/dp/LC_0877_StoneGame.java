//

package dp;

public class LC_0877_StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];

        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = piles.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < piles.length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][piles.length - 1] >= 0;
    }
}
