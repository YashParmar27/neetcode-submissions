class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> mySet = new HashSet<>();
        
        int i, j = 0;
        int maxCount = 0;
        int currCount = 0;
        while (j < s.length())
        {
            if (!mySet.contains(s.charAt(j)))
            {
                mySet.add(s.charAt(j));
                j++;
                currCount++;
                if (currCount > maxCount)
                    maxCount = currCount;
            }
            else
            {
                i = j;
                char dup_char = s.charAt(j);
                while (i >= 1 && s.charAt(i - 1) != dup_char)
                    i--;
                
                while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1))
                    j++;
                mySet.clear();
                currCount = 0;
                j = i;
            }
        }
        return maxCount;
    }
}
