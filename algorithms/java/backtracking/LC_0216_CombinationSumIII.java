// https://leetcode.com/problems/combination-sum-iii/description

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC_0216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(k, n, 1, 0, curr, combinations);

        return combinations;
    }

    private void backtrack(int k, int n, int start, int sum, List<Integer> curr, List<List<Integer>> combinations) {
        if (sum > n || curr.size() > k) {
            return;
        }

        if (sum == n && curr.size() == k) {
            combinations.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= 9; i++) {
            curr.add(i);
            sum += i;

            backtrack(k, n, i + 1, sum, curr, combinations);

            sum -= i;
            curr.removeLast();
        }
    }
}
