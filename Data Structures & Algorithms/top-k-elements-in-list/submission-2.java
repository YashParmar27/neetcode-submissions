class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Store a hash map with each element and it's frquency
        // Create an array of lists of integers, starting from 0 -> n
        // Index represents frequency, value at that index represents
        // numbers w/ that freq.
        // Start from the highest frequency, add k first numbers into 
        // the result set and return.

        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int num : nums)
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

        List<Integer>[] frequencyList = new List[nums.length + 1];
        for (int i = 0; i < frequencyList.length; i++)
            frequencyList[i] = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet())
            frequencyList[entry.getValue()].add(entry.getKey());

        int[] result = new int[k];
        int index = 0;
        for (int i = frequencyList.length - 1; i > 0 && index < k; i--)
        {
            for (int n : frequencyList[i])
            {
                result[index++] = n;
                if (index == k)
                {
                    return result;
                }
            }
        }
        return result;
    }
}
