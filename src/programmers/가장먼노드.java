package programmers;

import java.util.*;

public class 가장먼노드 {
    public static int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1); //fill은 해당 값으로 다 채워줌

        ArrayDeque<Integer> q = new ArrayDeque<>(); //deque가 배열기반 더 빠르다고함
        dist[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                 if (dist[next] == -1) {
                     dist[next] = dist[cur] + 1;
                     q.add(next);
                 }
            }
        }

        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
             maxDist = Math.max(maxDist, dist[i]);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n,vertex));
    }
}
