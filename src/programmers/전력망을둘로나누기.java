package programmers;

import java.util.ArrayList;
import java.util.List;

public class 전력망을둘로나누기 {

    List<Integer>[] graph;
    boolean[] visited;
    int count;

    public int solution(int n, int[][] wires) {
        int answer = 101;

        for (int i = 0; i < wires.length; i++) {

            graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;

                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }

            visited = new boolean[n + 1];
            count = 0;
            dfs(1);

            int diff = Math.abs((n - count) - count);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    void dfs(int node) {
        visited[node] = true;
        count++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    void main(String[] args) {
        int n1 = 9;
        int[][] wires1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int n2 = 4;
        int[][] wires2 = {{1,2},{2,3},{3,4}};

        int n3= 7;
        int[][] wires3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        System.out.println(solution(n1,wires1));
        System.out.println(solution(n2,wires2));
        System.out.println(solution(n3,wires3));
    }
}