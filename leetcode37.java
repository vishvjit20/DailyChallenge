class leetcode37 {

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
    }

    boolean solveSudokuHelper(char[][] board, int i, int j) {
        if (j == board[0].length) {
            i = i + 1;
            j = 0;
        }

        if (i == board.length)
            return true;
        if (board[i][j] != '.') {
            if (solveSudokuHelper(board, i, j + 1))
                return true;
        } else {
            for (int d = 1; d <= 9; d++) {
                if (isItSafeToPlaceDigit(board, i, j, d)) {
                    board[i][j] = (char) (d + '0');
                    if (solveSudokuHelper(board, i, j + 1))
                        return true;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    boolean isItSafeToPlaceDigit(char[][] board, int i, int j, int d) {
        for (int c = 0; c < 9; c++) {
            if (board[i][c] == (char) (d + '0'))
                return false;
        }

        for (int r = 0; r < 9; r++) {
            if (board[r][j] == (char) (d + '0'))
                return false;
        }

        int subMatrixRowStart = (i / 3) * 3;
        int subMatrixColStart = (j / 3) * 3;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row + subMatrixRowStart][col + subMatrixColStart] == (char) (d + '0')) {
                    return false;
                }
            }
        }

        return true;
    }
}
