class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int l = 0;
        for (int r = 0; r < nums.length; r++)
        {
            maxHeap.offer(nums[r]);
            if (maxHeap.size() == k)
            {
                int max = maxHeap.peek();
                ans[l] = max;

                maxHeap.remove(nums[l]);
                l++;
            }
        }
        return ans;
    }
}
