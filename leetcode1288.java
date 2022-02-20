import java.util.*;

class leetcode1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int max = intervals[0][1];
        int res = 1;
        for (int val[] : intervals) {
            if (val[1] > max) {
                res++;
                max = val[1];
            }
        }
        return res;
    }
}
