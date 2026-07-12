package programmers;

public class 네트워크 {
    static int n;
    static int[][] computers;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;

    }

    void dfs(int num) {
        visited[num] = true;

        for (int next = 0; next < n; next++) {
            if (computers[num][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }

    public void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(solution(n, computers));
    }
}