class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        dfs(0, nums, 0, target, res, set);

        return res;
    }

    private void dfs(int i, int[] nums, int sum, int target, List<List<Integer>> res, List<Integer> set)
    {
        if (sum > target || i >= nums.length)
            return;

        if (sum == target)
        {
            res.add(new ArrayList<>(set));
            return;
        }
        set.add(nums[i]);
        dfs(i, nums, sum + nums[i], target, res, set);
        set.remove(set.size() - 1);
        dfs(i + 1, nums, sum, target, res, set);
    }
}
