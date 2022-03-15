import java.util.*;

public class leetcode921 {
    public int minAddToMakeValid(String s) {
        // Stack<Character> stk = new Stack<>();

        // for (int i = 0; i < s.length(); i++) {
        // char c = s.charAt(i);
        // if (c == '(')
        // stk.push(c);
        // else {
        // if (stk.size() > 0 && stk.peek() == '(')
        // stk.pop();
        // else
        // stk.push(c);
        // }
        // }

        // return stk.size();
        int countOpen = 0, countClose = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                countOpen++;
            else if (countOpen > 0)
                countOpen--;
            else
                countClose++;
        }

        return countClose + countOpen;
    }
}
