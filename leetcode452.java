import java.util.*;

class leetcode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrow = 1, end = points[0][1];
        for (int point[] : points) {
            if (point[0] > end) {
                arrow++;
                end = point[1];
            }
        }
        return arrow;
    }
}

/**
 * [[10,13],[3,5],[5,7],[1,5],[2,6],[12,14]]
 * 3 - 5
 * 1 - 5
 * 2 - 6
 * 5 - 7
 * 10 - 13
 * 12 - 14
 */
