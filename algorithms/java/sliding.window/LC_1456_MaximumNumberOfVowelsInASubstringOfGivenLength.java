// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description

package sliding.window;

import java.util.Set;

public class LC_1456_MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int maxCount = -1;
        int currLength = 0;
        int vowelsCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelsCount++;
            }
            currLength++;

            if (currLength > k) {
                currLength--;
                vowelsCount -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
            }

            if (currLength == k) {
                maxCount = Math.max(maxCount, vowelsCount);
            }
        }

        return maxCount;
    }
}
