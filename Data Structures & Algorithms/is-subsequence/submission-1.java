class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < t.length())
        {
            if (j < s.length() && t.charAt(i) == s.charAt(j))
            {
                j++;
            }
            i++;
        }

        if (j == s.length())
            return true;
        else
            return false;
    }
}