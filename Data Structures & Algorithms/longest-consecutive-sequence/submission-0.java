class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }
        int res = 0;
   
        for (int i = 0; i < nums.length; i++)
        {
            int streak = 0;
            int curr = nums[i];
            while (set.contains(curr))
            {
                curr++;
                streak++;
            }
            res = Math.max(res, streak);
        }
        
        return res;
    }
}
