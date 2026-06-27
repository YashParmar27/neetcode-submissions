class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++)
        {
            int s = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i])
            {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                res = Math.max(res, height * (i - index));
                s = index;
            }
            stack.push(new int[]{s, heights[i]});
        }

        for (int[] pair : stack)
        {
            int index = pair[0];
            int height = pair[1];
            res = Math.max(res, height * (heights.length - index));
        }
        return res;
    }
}
