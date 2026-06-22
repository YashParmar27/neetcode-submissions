class Solution {
    public boolean isValid(String s) 
    {
        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> map = Map.of(
            ')','(',
            '}','{',
            ']' ,'['
        );

        for (char c : s.toCharArray())
        {
            if (map.containsKey(c))
            {
                if (!stack.isEmpty() && stack.peek() == map.get(c))
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
