class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Building the prefix and suffix arrays:
        int[] prefixArray = new int[nums.length];
        int[] suffixArray = new int[nums.length];
        int[] result = new int[nums.length];

        // For prefix array:
        prefixArray[0] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            prefixArray[i] = prefixArray[i - 1] * nums[i - 1];
        }

        // For suffix array:
        suffixArray[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--)
        {
            suffixArray[i] = suffixArray[i + 1] * nums[i + 1];
        }

        // For result:
        for (int i = 0; i < nums.length; i++)
        {
            result[i] = prefixArray[i] * suffixArray[i];
        }
        
        return result;
    }
}  
