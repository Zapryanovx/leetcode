// https://leetcode.com/problems/domino-and-tromino-tiling/description

package dp;

public class LC_0790_DominoAndTrominoTiling {
    static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 5;
        }

        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 5;

        for (int i = 4; i <= n; i++) {
            ways[i] = (int) ((2L * ways[i - 1] + ways[i - 3]) % MOD);
        }

        return ways[n];
    }
}
