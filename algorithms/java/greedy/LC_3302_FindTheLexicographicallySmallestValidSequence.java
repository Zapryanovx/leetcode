// https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/description

package greedy;

public class LC_3302_FindTheLexicographicallySmallestValidSequence {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suffix = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }

            suffix[i] = m - 1 - j;
        }

        int[] answer = new int[m];
        int k = 0;
        boolean changed = false;

        for (int i = 0; i < n && k < m; i++) {
            if (word1.charAt(i) == word2.charAt(k)) {
                answer[k] = i;
                k++;
            } else if (!changed && suffix[i + 1] >= m - k - 1) {
                answer[k] = i;
                k++;
                changed = true;
            }
        }

        if (k == m) {
            return answer;
        }
        return new int[0];
    }
}
