import java.util.*;

public class leetcode856 {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stk.push(-1);
            else {
                if (stk.peek() == -1) {
                    stk.pop();

                    stk.push(1);
                } else {
                    int val = 0;
                    while (stk.peek() != -1)
                        val += stk.pop();
                    stk.pop();
                    stk.push(2 * val);
                }
            }
        }

        int val = 0;
        while (stk.size() > 0)
            val += stk.pop();
        return val;
    }
}
