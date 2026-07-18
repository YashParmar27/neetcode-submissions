class Solution {
    String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
        };
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;
        dfs(0, "", digits);
        return res;
    }

    public void dfs(int i, String curr, String digits)
    {
        if (curr.length() == digits.length())
        {
            res.add(curr);
            return;
        }

        String letters = map[digits.charAt(i) - '0'];
        for (char c : letters.toCharArray())
        {
            dfs(i + 1, curr + c, digits);
        }
    }
}
