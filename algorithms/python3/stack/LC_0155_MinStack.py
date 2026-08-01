# https://leetcode.com/problems/min-stack/description/

class MinStack:
    def __init__(self):
        self.min_num = float('inf')
        self.container = []

    def push(self, val: int) -> None:
        if val <= self.min_num:
            self.container.append(self.min_num)
            self.min_num = val

        self.container.append(val)

    def pop(self) -> None:
        if self.container[-1] == self.min_num:
            self.container.pop()
            self.min_num = self.container[-1]
        self.container.pop()

    def top(self) -> int:
        return self.container[-1]

    def getMin(self) -> int:
        return self.min_num