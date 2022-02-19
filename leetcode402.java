import java.util.*;

public class leetcode402 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k)
            return "0";
        Stack<Character> stk = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stk.isEmpty() && stk.peek() > num.charAt(i)) {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
            i++;
        }
        while (k > 0) {
            stk.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
