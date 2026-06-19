class Solution {
    public boolean hasDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            int curr_elem = nums[i];
            for (int j = i + 1; j < nums.length; j++)
            {
                if(nums[j] == curr_elem)
                {
                    return true;
                }
            }
        }
        return false;
    }
}