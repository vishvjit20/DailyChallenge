import java.util.*;

class leetcode1249 {
    public String minRemoveToMakeValid(String s) {
        char chars[] = s.toCharArray();
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(')
                stk.push(i);
            else if (chars[i] == ')') {
                if (stk.size() == 0)
                    chars[i] = '.';
                else
                    stk.pop();
            }
        }

        while (stk.size() > 0) {
            chars[stk.pop()] = '.';
        }

        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            if (c != '.') {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
