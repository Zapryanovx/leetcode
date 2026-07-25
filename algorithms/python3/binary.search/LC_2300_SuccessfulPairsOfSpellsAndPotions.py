# https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description

class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()

        pairs = []
        for s in spells:
            l = 0
            r = len(potions) - 1

            while l <= r:
                m = (l + r) // 2

                if s * potions[m] >= success:
                    r = m - 1
                else:
                    l = m + 1

            pairs.append(len(potions) - l)

        return pairs