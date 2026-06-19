class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hashMap = new HashMap<>();

        for (int num : nums)
        {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        List<int[]> array = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet())
        {
            array.add(new int[] {entry.getValue(), entry.getKey()});
        }
        array.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
        {
            res[i] = array.get(i)[1];
        }

        return res;
    }
}
