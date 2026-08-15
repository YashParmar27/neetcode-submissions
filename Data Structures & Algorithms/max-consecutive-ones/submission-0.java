class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int count = 0;
        int max = 0;

        while (i < nums.length)
        {
            while (i < nums.length && nums[i] == 1)
            {
                i++;
                count++;
            }
            max = Math.max(count, max);
            count = 0;
            i++;
        }
        return max;
    }
}