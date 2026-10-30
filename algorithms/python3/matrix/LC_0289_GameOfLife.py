# https://leetcode.com/problems/game-of-life/description

class Solution:
    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        row_directions = [-1, 0, 1]
        col_directions = [-1, 0, 1]
        board_cache = copy.deepcopy(board)

        for r in range(len(board)):
            for c in range(len(board[0])):
                cnt = 0

                for rd in row_directions:
                    for cd in col_directions:
                        if r + rd < 0 or r + rd >= len(board):
                            continue
                        if c + cd < 0 or c + cd >= len(board[0]):
                            continue
                        if rd == cd == 0:
                            continue

                        if board_cache[r + rd][c + cd] == 1:
                            cnt += 1

                if board_cache[r][c] == 1:
                    if cnt < 2 or cnt > 3:
                        board[r][c] = 0
                else:
                    if cnt == 3:
                        board[r][c] = 1