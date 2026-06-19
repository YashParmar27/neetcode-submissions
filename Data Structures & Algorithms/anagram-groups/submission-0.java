class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Iterate over each string
        // Sort each string
        // Add an entry to the hash with the value as the index
        // Form a list of lists with each entry of the hash table

        Map<String,List<String>> hashMap = new HashMap<>();
        
        for (String s: strs)
        {
            char[] chr = s.toCharArray();
            Arrays.sort(chr);
            String sortedString = new String(chr);

            hashMap.putIfAbsent(sortedString, new ArrayList<>());
            hashMap.get(sortedString).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }
}
