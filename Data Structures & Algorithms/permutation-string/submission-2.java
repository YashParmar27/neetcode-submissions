class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map2 = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        for (char c: s1.toCharArray())
        {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++)
        {
            char c = s2.charAt(r);

            if (!map1.containsKey(c))
            {
                l = r + 1;
                map2.clear();
                continue;
            }
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            while (map2.get(c) > map1.get(c))
            {
                map2.put(s2.charAt(l), map2.get(s2.charAt(l)) - 1);
                l++;
            }

            if ((r - l + 1) == s1.length())
                return true;
        }
        return false;
    }
}
