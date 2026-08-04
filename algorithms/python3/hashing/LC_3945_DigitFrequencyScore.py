# https://leetcode.com/problems/digit-frequency-score/description/

class Solution:
    def digitFrequencyScore(self, n: int) -> int:
        occs = dict()

        while n > 0:
            d = n % 10
            if d in occs:
                occs[d] += 1
            else:
                occs[d] = 1
            n //= 10

        score = 0
        for k in occs.keys():
            score += k * occs[k]

        return score