class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        dfs(s, n, 0, 0);
        return res;
    }

    public void dfs(StringBuilder subset, int n, int open, int close)
    {
        if (open == close && open == n)
        {
            res.add(subset.toString());
            return;
        }

        if (open < n)
        {
            subset.append("(");
            dfs(subset, n, open + 1, close);
            subset.deleteCharAt(subset.length() - 1);
        }
        if (close < open)
        {
            subset.append(')');
            dfs(subset, n, open, close + 1);
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
