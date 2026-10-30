# https://leetcode.com/problems/substring-with-concatenation-of-all-words/description

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        w = len(words[0])
        total = w * len(words)
        need = Counter(words)

        if len(s) < total:
            return []

        def matches(curr):
            chunks = [curr[j:j + w] for j in range(0, total, w)]
            return Counter(chunks) == need

        indices = []

        curr = s[0:total]
        start = 0

        for i in range(total, len(s)):
            if matches(curr):
                indices.append(start)

            start += 1
            curr = curr[1:] + s[i]

        if matches(curr):
            indices.append(start)

        return indices