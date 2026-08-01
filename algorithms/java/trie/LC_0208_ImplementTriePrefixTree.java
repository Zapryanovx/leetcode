// https://leetcode.com/problems/implement-trie-prefix-tree/description

package trie;

public class LC_0208_ImplementTriePrefixTree {
    static class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char c: word.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new Trie();
                }
                node = node.children[i];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = find(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }

        private Trie find(String s) {
            Trie node = this;
            for (char c: s.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    return null;
                }
                node = node.children[i];
            }
            return node;
        }
    }
}
