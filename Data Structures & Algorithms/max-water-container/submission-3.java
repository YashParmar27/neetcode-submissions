class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int res = 0;

        while (i < j)
        {
            int len = Math.min(heights[i], heights[j]);
            int bdh = j - i;

            int curr_sum = len * bdh;
            if (curr_sum > res)
            {
                res = curr_sum;
            }
            
            if (heights[i] < heights[j]) 
            {
                i++;
            } 
            else 
            {
                j--;
            }
        }
        return res;
    }
}
