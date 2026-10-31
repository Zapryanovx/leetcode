# https://leetcode.com/problems/simplify-path/description

import re

class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        print(re.split(r'/+', path))
        for d in re.split(r'/+', path):
            if d == '.' or d == "":
                continue
            elif d == '..':
                if stack:
                    stack.pop()
            else:
                stack.append(d)

        return "/" + "/".join(stack)
