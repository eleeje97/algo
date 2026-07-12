package programmers;

public class 네트워크 {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            answer++;

            dfs(i, n, computers);
        }

        return answer;
    }

    void dfs(int i, int n, int[][] computers) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1) {
                dfs(j, n, computers);
            }
        }
    }

    public static void main(String[] args) {
        네트워크 sol = new 네트워크();
        System.out.println(sol.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(sol.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

}
