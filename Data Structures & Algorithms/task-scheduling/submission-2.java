class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char c : tasks)
        {
            count[c - 'A'] += 1;
        }

        int maxF = 0;
        for (int cn : count)
        {
            if (cn > maxF)
                maxF = cn;
        }

        int maxA = 0;
        for (int cn : count)
        {
            if (cn == maxF)
                maxA += 1;
        }

        return Math.max(((maxF - 1) * (n + 1) + maxA), tasks.length);

    }
}
