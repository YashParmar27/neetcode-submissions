class Solution {
    public String minWindow(String s, String t) {

        Map<Character,Integer> map_t = new HashMap<>();
        for (char c: t.toCharArray())
            map_t.put(c, map_t.getOrDefault(c, 0) + 1);
        
        Map<Character,Integer> map_s = new HashMap<>();
        int l = 0;

        int required = map_t.size();
        int count = 0;

        int bestL = 0, bestLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++)
        {
            char c = s.charAt(r);
            map_s.put(c, map_s.getOrDefault(c, 0) + 1);
            if (map_s.get(c).equals(map_t.getOrDefault(c, 0)))
                count++;
            
            while (count == required)
            {
                if ( (r - l + 1) < bestLen)
                {
                    bestLen = r - l + 1;
                    bestL = l;
                }
                char left = s.charAt(l);
                map_s.put(left, map_s.get(left) - 1);
                if (map_s.get(left) < map_t.getOrDefault(left, 0))
                    count--;
                l++;
            }
        }
        if (bestLen >= Integer.MAX_VALUE)
            return "";
        else
            return s.substring(bestL, bestL + bestLen);
    }
}
