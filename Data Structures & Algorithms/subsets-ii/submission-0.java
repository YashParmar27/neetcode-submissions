class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        dfs(0, res, subset, nums);
        return res;
    }

    public void dfs(int i, List<List<Integer>> res, List<Integer> subset, int[] nums)
    {
        if (i == nums.length)
        {
            res.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[i]);
        dfs(i + 1, res, subset, nums);
        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1])
            i++;
        dfs(i + 1, res, subset, nums);
    }
}
