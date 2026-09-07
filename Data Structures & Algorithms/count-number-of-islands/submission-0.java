class Solution 
{
    int num;
    public int numIslands(char[][] grid) 
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < visited.length; i++)
        {
            for (int j = 0; j < visited[0].length; j++)
            {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1' && !visited[i][j])
                {
                    dfs(i, j, grid, visited);
                    num++;
                }
            }
        }

        return num;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visited)
    {
        if (i < 0 || j >= grid[0].length || i >= grid.length || j < 0 
            || visited[i][j] || grid[i][j] == '0')
        {
            return;
        }

        visited[i][j] = true;
        
        dfs(i, j + 1, grid, visited);
        dfs(i + 1, j, grid, visited);
        dfs(i - 1, j, grid, visited);
        dfs(i, j - 1, grid, visited);
    }
}
