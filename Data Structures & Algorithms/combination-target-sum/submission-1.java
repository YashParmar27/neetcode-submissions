class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        dfs(0, nums, target, set);

        return res;
    }

    private void dfs(int i, int[] nums, int target, List<Integer> set)
    {
        if (target == 0)
        {
            res.add(new ArrayList<>(set));
            return;
        }

        if (i >= nums.length || target < 0)
            return;
        
        set.add(nums[i]);
        dfs(i, nums, target - nums[i], set);
        set.remove(set.size() - 1);

        dfs(i + 1, nums, target, set);
    }
}
