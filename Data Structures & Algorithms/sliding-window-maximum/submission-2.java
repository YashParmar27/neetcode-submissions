class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        
        Deque<Integer> list = new LinkedList<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++)
        {
            while (!list.isEmpty() && nums[list.getLast()] < nums[r])
                list.removeLast();
            list.addLast(r);

            if (l > list.getFirst())
                list.removeFirst();
            
            if ((r + 1) >= k)
            {
                ans[l] = nums[list.getFirst()];
                l++;
            }
        }
        return ans;
    }
}
