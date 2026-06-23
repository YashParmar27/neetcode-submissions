class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = Set.of("+", "-", "/", "*");

        for (String s : tokens)
        {
            if (!operators.contains(s))
            {
                stack.push(Integer.parseInt(s));
                System.out.println("Pushing int ->" + Integer.parseInt(s));
            }
            else
            {
                int num1 = 0; 
                int num2 = 0;
                int res = 0;

                if (!stack.isEmpty())
                    num1 = stack.pop();
                if (!stack.isEmpty())
                    num2 = stack.pop();
                
                if (s.equals("+"))
                {
                    res = num2 + num1;
                }
                else if (s.equals("-"))
                {
                    res = num2 - num1;
                }
                else if (s.equals("*"))
                {
                    res = num2 * num1;
                }
                else
                {
                    res = num2 / num1;
                }
                System.out.println("Pushing res->" + res);
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
