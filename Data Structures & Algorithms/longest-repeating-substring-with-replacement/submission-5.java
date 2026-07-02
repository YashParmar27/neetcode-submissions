class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        Map<Character,Integer> count = new HashMap<>();
        int l = 0, maxf = 0;
        for (int r = 0; r < s.length(); r++)
        {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(count.get(s.charAt(r)), maxf);
            
            while ((r - l + 1) - maxf > k)
            {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}
