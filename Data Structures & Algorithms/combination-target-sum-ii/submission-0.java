class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates, 0, 0, subset, target);
        return res;
    }

    public void dfs(int[] candidates, int i, int sum, List<Integer> subset, int target)
    {
        if (sum == target)
        {
            res.add(new ArrayList<>(subset));
            return;
        }

        if (i >= candidates.length || sum > target)
            return;

        subset.add(candidates[i]); 
        dfs(candidates, i + 1, sum + candidates[i], subset, target);
        subset.remove(subset.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1])
            i++;
        dfs(candidates, i + 1, sum, subset, target);
    }
}
