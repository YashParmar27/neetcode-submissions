class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
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
                if (!visited[i][j] && grid[i][j] == 1)
                {
                    int area = dfs(i, j, grid, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    int dfs(int i, int j, int[][] grid, boolean[][] visited)
    {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0
            || visited[i][j] || grid[i][j] == 0)
        {
            return 0;
        }
        visited[i][j] = true;
        int area = 1;

        area += dfs(i, j + 1, grid, visited);
        area += dfs(i + 1, j, grid, visited);
        area += dfs(i - 1, j, grid, visited);
        area += dfs(i, j - 1, grid, visited);

        return area;
    }
}
