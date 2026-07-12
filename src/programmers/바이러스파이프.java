package programmers;

import java.util.*;

public class 바이러스파이프 {
    static int N;
    static int K;
    static int answer;
    static List<Edge>[] graph;

    public static int solution(int n, int infection, int[][] edges, int k) {
        N = n;
        K = k;
        answer = 1;

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];

            graph[x].add(new Edge(y, type));
            graph[y].add(new Edge(x, type));
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        dfs(0, infected);

        return answer;
    }

    static class Edge {
        int part;
        int type;

        Edge(int part, int type) {
            this.part = part;
            this.type = type;
        }
    }

    static void boom(int type, boolean[] infected) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (infected[i]) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int j = queue.poll();

            for (Edge edge : graph[j]) {
                if (edge.type != type) continue;

                int next = edge.part;

                if (infected[next]) continue;

                infected[next] = true;
                queue.offer(next);
            }
        }
    }

    static void dfs(int depth, boolean[] infected) {
        int cnt = countInfected(infected);
        answer = Math.max(answer, cnt);

        if (depth == K) {
            return;
        }

        for (int type = 1; type <= 3; type++) {
            boolean[] next = infected.clone();

            boom(type, next);

            dfs(depth + 1, next);
        }
    }

    static int countInfected(boolean[] infected) {
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (infected[i]) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int n = 10;
        int infection = 1;
        int[][] edges = {{1, 2, 1}, {1, 3, 1}, {1, 4, 3}, {1, 5, 2}, {5, 6, 1}, {5, 7, 1}, {2, 8, 3}, {2, 9, 2}, {9, 10, 1}};
        int k = 2;

        int n2 = 7;
        int infection2 = 6;
        int[][] edges2 = {{1, 2, 3}, {1, 4, 3}, {4, 5, 1}, {5, 6, 1}, {3, 6, 2}, {3, 7, 2}};
        int k2 = 3;

        System.out.println(solution(n,infection,edges, k));
        System.out.println(solution(n2,infection2,edges2, k2));
    }
}