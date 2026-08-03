// https://leetcode.com/problems/stone-game-iii/description

package dp;

public class LC_1406_StoneGameIII {
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length + 1];
        dp[stoneValue.length] = 0;

        for (int i = stoneValue.length - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int k = 1; k <= 3 && i + k <= stoneValue.length; k++) {
                sum += stoneValue[i + k - 1];
                max = Math.max(max, sum - dp[i + k]);
            }
            dp[i] = max;
        }

        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        }
        return "Tie";
    }
}
