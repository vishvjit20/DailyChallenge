import java.util.*;

class leetcode1345 {
    public int minJumps(int arr[]) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0] = true;
        int steps = 0;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int i = que.remove();
                if (i == n - 1)
                    return steps;
                List<Integer> next = map.get(arr[i]);
                next.add(i - 1);
                next.add(i + 1);
                for (int j : next) {
                    if (j >= 0 && j < n && !visited[j]) {
                        visited[j] = true;
                        que.add(j);
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
