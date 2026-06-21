class Solution {
    public boolean isPalindrome(String s) {
    
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
        {
            if (!Character.isLetterOrDigit(c))
                continue;
            sb.append(Character.toLowerCase(c));
        }
        String ns = sb.toString();

        int n = ns.length();
        int i = 0;
        int j = n - 1;

        while (i < j)
        {
            if (ns.charAt(i++) != ns.charAt(j--))
                return false;
        }
        return true;
    }
}
