class Solution {
    public int findMin(int[] nums) {
        // a pattern i noticed:
        // number to left -> bigger, number to right -> smaller
        // true for all smallest elements
        int mid = 0;

        int l = 0;
        int r = nums.length - 1;

        while (l < r)
        {
            mid = (l + r) / 2;
            if (nums[mid] < nums[r])
                r = mid;
            else
                l = mid + 1;
        }
        return nums[l];
    }
}
