import java.util.*;

public class leetcode84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nsl[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        nsl[0] = -1;
        for (int i = 1; i < n; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if (!stk.isEmpty())
                nsl[i] = stk.peek();
            else
                nsl[i] = -1;
            stk.push(i);
        }

        int nsr[] = new int[n];
        stk = new Stack<>();
        stk.push(n - 1);
        nsr[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                nsr[i] = stk.peek();
            } else {
                nsr[i] = n;
            }
            stk.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = width * heights[i];
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
