import java.util.*;

class leetcode847 {
    class Node {
        int visited, dist, node;

        Node(int visited, int dist, int node) {
            this.visited = visited;
            this.dist = dist;
            this.node = node;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1)
            return 0;
        final int FINAL_STATE = (1 << n) - 1;
        Set<Integer>[] visited = new HashSet[n];
        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            visited[i] = new HashSet<>();
            que.add(new Node(1 << i, 0, i));
            visited[i].add(1 << i);
        }
        while (!que.isEmpty()) {
            Node rem = que.remove();
            if (rem.visited == FINAL_STATE) {
                return rem.dist;
            }

            for (int nbr : graph[rem.node]) {
                int mask = rem.visited | 1 << nbr;
                if (visited[nbr].add(mask)) {
                    que.add(new Node(mask, rem.dist + 1, nbr));
                }
            }
        }

        return -1;
    }
}
