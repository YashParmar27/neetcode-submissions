class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Run three checks for duplicates using a set: 
        // 1. Check for rows
        // 2. Check for columns
        // 3. Check for 3 x 3 subBoxes

        for (int i = 0; i < board.length; i++)
        {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++)
            {
                if (board[i][j] != '.')
                {
                    if (set.contains(board[i][j]))
                        return false;
                    else
                        set.add(board[i][j]);
                }
            }
        }

        for (int i = 0; i < board.length; i++)
        {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++)
            {
                if (board[j][i] != '.')
                {
                    if (set.contains(board[j][i]))
                        return false;
                    else
                        set.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < 9; i++)
        {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    int row = (i / 3) * 3 + j;
                    int col = (i % 3) * 3 + k;

                    if (board[row][col] != '.')
                    {
                        if (set.contains(board[row][col]))
                            return false;
                        else
                            set.add(board[row][col]);
                    }
                }
            }
        }
        
        return true;
    }
}
