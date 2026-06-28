class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
            return false;
        
        int l = 0;
        int r = n - 1;

        int index = 0;

        int row_l = 0;
        int row_r = m - 1;
        
        while (row_l <= row_r)
        {
            int mid_row = (row_l + row_r) / 2;
            if (matrix[mid_row][0] <= target && matrix[mid_row][n - 1] >= target)
            {
                index = mid_row;
                break;
            }
            else if (matrix[mid_row][0] < target)
                row_l = mid_row + 1;
            else
                row_r = mid_row - 1;
        }

        while (l <= r)
        {
            int mid = (l + r) / 2;
            if (matrix[index][mid] == target)
                return true;
            else if (matrix[index][mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
}
