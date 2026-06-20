class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }
        int longest = 0;

        for (int num : nums)
        {
            if (set.contains(num - 1)) continue;
            int curr = num;
            int streak = 0;

            while (set.contains(curr))
            {
                curr++;
                streak++;
            }
            longest = Math.max(longest, streak);
        }
        return longest;
    }
}
