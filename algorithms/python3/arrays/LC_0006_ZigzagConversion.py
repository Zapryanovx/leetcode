# https://leetcode.com/problems/zigzag-conversion/description

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        rows = [""] * numRows

        row = 0
        direction = 1
        for ch in s:
            rows[row] += ch

            if row == numRows - 1:
                direction = -1
            if row == 0:
                direction = 1

            row += direction

        return "".join(rows)

