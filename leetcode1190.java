import java.util.*;

public class leetcode1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        Deque<Character> que = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ')')
                stk.push(c);
            else {
                while (!stk.isEmpty() && stk.peek() != '(')
                    que.add(stk.pop());
                if (!stk.isEmpty())
                    stk.pop();
                while (!que.isEmpty())
                    stk.push(que.removeFirst());
            }
        }

        while (!stk.isEmpty())
            sb.append(stk.pop());

        return sb.reverse().toString();
    }
}
