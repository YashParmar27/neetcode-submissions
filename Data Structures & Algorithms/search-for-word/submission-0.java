class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length, COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                if (dfs(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int idx, String word)
    {
        int ROWS = board.length, COLS = board[0].length;
        if (idx == word.length())
            return true;
        
        if (i >= ROWS || j >= COLS || i < 0 || j < 0 || word.charAt(idx) != board[i][j] || visited[i][j])
            return false;
        
        idx += 1;
        visited[i][j] = true;
        boolean found = dfs(board, i, j + 1, idx, word) || dfs(board, i, j - 1, idx, word)
                     || dfs(board, i + 1, j, idx, word) || dfs(board, i - 1, j, idx, word);
        visited[i][j] = false;
        return found;
    }
}
