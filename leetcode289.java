class leetcode289 {
    public void gameOfLife(int[][] board) {
        int neighbours[] = { 0, -1, 1 };
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbours = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbours[i] == 0 && neighbours[j] == 0)) {
                            int r = row + neighbours[i];
                            int c = col + neighbours[j];

                            if (r >= 0 && c >= 0 && r < rows && c < cols && Math.abs(board[r][c]) == 1) {
                                liveNeighbours++;
                            }
                        }
                    }
                }
                if (board[row][col] == 1 && (liveNeighbours < 2 || liveNeighbours > 3)) {
                    board[row][col] = -1;
                }
                if (board[row][col] == 0 && liveNeighbours == 3) {
                    board[row][col] = 2;
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0)
                    board[row][col] = 1;
                else
                    board[row][col] = 0;
            }
        }
    }
}
