// https://leetcode.com/problems/word-pattern/description

package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LC_0290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, Integer> charMap = new HashMap<>();
        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            Integer previousCharIndex = charMap.put(ch, i);
            Integer previousWordIndex = wordMap.put(word, i);

            if (!Objects.equals(previousCharIndex, previousWordIndex)) {
                return false;
            }
        }

        return true;
    }
}
