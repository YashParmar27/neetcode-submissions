class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
        {
            Map<Character,Integer> count = new HashMap<>();
            int maxf = 0;
            for (int j = i; j < s.length(); j++)
            {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxf = Math.max(count.get(s.charAt(j)), maxf);
                if ((j - i + 1) - maxf <= k)
                {
                    res = Math.max(j - i + 1, res);
                }
            }
        }
        return res;
    }
}
