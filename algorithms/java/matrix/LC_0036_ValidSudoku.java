package matrix;

import java.util.HashSet;
import java.util.Set;

public class LC_0036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        Set<String> finds = new HashSet<String>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                if (finds.contains(board[row][col] + " in row " + row)
                        || finds.contains(board[row][col] + " in col " + col)
                        || finds.contains(board[row][col] + " in box " + "(" + row / 3 + "," + col / 3 + ")")) {
                    return false;
                }

                finds.add(board[row][col] + " in row " + row);
                finds.add(board[row][col] + " in col " + col);
                finds.add(board[row][col] + " in box " + "(" + row / 3 + "," + col / 3 + ")");
            }
        }

        return true;
    }
}
