// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC_0017_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        backtrack(digits, letters, combinations, sb, 0);
        return combinations;
    }

    private void backtrack(String digits, String[] letters, List<String> combinations, StringBuilder sb, int pos) {
        if (pos == digits.length()) {
            combinations.add(sb.toString());
            return;
        }

        for (char l: letters[digits.charAt(pos) - '0'].toCharArray()) {
            sb.append(l);
            backtrack(digits, letters, combinations, sb, pos + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
