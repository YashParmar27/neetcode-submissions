class Solution {
    public int carFleet(int target, int[] position, int[] speed) 
    {
       int[][] posSpeed = new int[position.length][2];
       for (int i = 0; i < position.length; i++)
       {
        posSpeed[i][0] = position[i];
        posSpeed[i][1] = speed[i];
       } 
        Arrays.sort(posSpeed, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] p : posSpeed)
        {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2))
            {
                stack.pop();
            }
        }
        return stack.size();
    }
}
