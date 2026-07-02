class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++)
        {
            int j = 0;
            int currMax = Integer.MIN_VALUE;
            while (j < k)
            {
                currMax = Math.max(nums[i + j], currMax);
                j++;
            }
            ans[i] = currMax;
        }
        return ans;
    }
}
