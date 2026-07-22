class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r)
        {
            if (s.charAt(l) == s.charAt(r))
            {
                l++;
                r--;
            }
            else
            {
                return isPallindrome(s.substring(0, l) + s.substring(l + 1)) || isPallindrome(s.substring(0, r) + s.substring(r + 1));
            }
        }
        return true;
    }

    public boolean isPallindrome(String s)
    {
        int l = 0;
        int r = s.length() - 1;

        while (l < r)
        {
            if (s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}