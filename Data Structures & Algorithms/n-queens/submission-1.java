class Solution {
    // Maintain a hashset for the column, the positive diagonal and the negative diagonal
    // I will try to place queens on each row, and if that particular index is in any set,
    // don't place it there.
    // state is the row I'm in
    List<List<String>> res = new ArrayList<>();
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board)
        {
            Arrays.fill(row, '.');
        }
        dfs(0, n, board);
        return res;
    }

    public void dfs(int r, int n, char[][] board)
    {
        if (r == n)
        {
            List<String> curr = new ArrayList<>();
            for (char[] row : board)
            {
                curr.add(new String(row));
            }
            res.add(curr);
            return;
        }
        // Iterating over the columns:
        for (int i = 0; i < n; i++)
        {
            if (colSet.contains(i) || posDiag.contains(r + i) || negDiag.contains(r - i))
                continue;

            board[r][i] = 'Q';
            posDiag.add(r + i);
            colSet.add(i);
            negDiag.add(r - i);
            dfs(r + 1, n, board);

            posDiag.remove(r + i);
            colSet.remove(i);
            negDiag.remove(r - i);
            board[r][i] = '.';
        }
    }
}
