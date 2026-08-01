// https://leetcode.com/problems/search-suggestions-system/description

package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1268_SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int left = 0;
        int right = products.length - 1;

        for (int i = 0; i < searchWord.length() && left <= right; i++) {
            char c = searchWord.charAt(i);

            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }

            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }

            List<String> suggestions = new ArrayList<>();
            int cnt = Math.min(3, right - left + 1);
            for (int j = 0; j < cnt; j++) {
                suggestions.add(products[left + j]);
            }
            result.add(suggestions);
        }

        while (result.size() < searchWord.length()) {
            result.add(new ArrayList<>());
        }

        return result;
    }
}
