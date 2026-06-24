class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Start from the last element, set it to 0
        // have a maxSoFar which keeps track of the max seen so far
        // push temperature in stack, if stack.peek is greater, just set 1
        // if elem > maxSoFar, update maxSoFar and set 0, and push
        // keep popping elems, until reach bigger, take count.

        Deque<Integer> stack = new ArrayDeque<>();

        int[] output = new int[temperatures.length];
        output[temperatures.length - 1] = 0;

        int maxSoFar = temperatures[temperatures.length - 1];
        stack.push(temperatures[temperatures.length - 1]);

        for (int i = temperatures.length - 2; i >= 0; i--)
        {
            if (temperatures[i] >= maxSoFar)
            {
                maxSoFar = temperatures[i];
                output[i] = 0;
                stack.push(temperatures[i]);
                continue;
            } else 
            {
                if (temperatures[i] < stack.peek())
                {
                    output[i] = 1;
                    stack.push(temperatures[i]);
                    continue;
                }
                else
                {
                    Deque<Integer> temp = new ArrayDeque<>();
                    int currElem = stack.peek();
                    int count = 0;
                    while (!stack.isEmpty() && currElem <= temperatures[i])
                    {
                        count++;
                        currElem = stack.pop();
                        temp.push(currElem);
                    }
                    output[i] = count;

                    while (!temp.isEmpty())
                    {
                        stack.push(temp.pop());
                    }
                    stack.push(temperatures[i]);
                }
            }
        }
        return output;
    }
}
