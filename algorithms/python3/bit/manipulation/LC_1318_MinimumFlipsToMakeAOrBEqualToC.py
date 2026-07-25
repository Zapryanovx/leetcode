# https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description

class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        flips = 0

        while a or b or c:
            bit_a = a & 1
            a >>= 1

            bit_b = b & 1
            b >>= 1

            bit_c = c & 1
            c >>= 1

            if bit_a + bit_b < bit_c:
                flips += 1
            elif bit_c == 0:
                flips += (bit_a +  bit_b)

        return flips