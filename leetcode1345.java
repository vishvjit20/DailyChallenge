import java.util.*;

class leetcode1345 {
    public int minJumps(int arr[]) {
        int n = arr.length;
        Map<Integer, List<Integer>> indicesOfValue = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indicesOfValue.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        }
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == n - 1)
                    return step;
                List<Integer> next = indicesOfValue.get(arr[i]);
                next.add(i - 1);
                next.add(i + 1);
                for (int j : next) {
                    if (j >= 0 && j < n && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                next.clear();
            }
            step++;
        }
        return 0;
    }
}
