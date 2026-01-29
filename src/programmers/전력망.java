package programmers;

public class 전력망 {
    static int answer;
    static boolean[][] board;
    static boolean[] visited;
    static int length;
    public static int solution(int n, int[][] wires) {
        // 8:30 ~ 8:56
        // 하나씩 끊어보면서 현재 답 보다 절대값이 적은지 검증
        // wires를 돌며 두 숫자를 선택
        // dfs, bfs에 넣는다
        // 갯수 검증 후 차이 갱신
        answer = Integer.MAX_VALUE;
        board = new boolean[n][n];
        visited = new boolean[n];
        for (int i = 0; i < wires.length; i++) {
            board[wires[i][0] - 1][wires[i][1] - 1] = true;
            board[wires[i][1] - 1][wires[i][0] - 1] = true;
        }
        for (int i = 0; i < wires.length; i++) {
            // 연결 끊고 dfs 넣기
            board[wires[i][0] - 1][wires[i][1] - 1] = false;
            board[wires[i][1] - 1][wires[i][0] - 1] = false;
            length = 1;
            visited[wires[i][0] - 1] = true;
            dfs(wires[i][0] - 1);
            visited[wires[i][0] - 1] = false;
            int a = length;
            length = 1;
            visited[wires[i][1] - 1] = true;
            dfs(wires[i][1] - 1);
            visited[wires[i][1] - 1] = false;
            int b = length;
            answer = Math.min(answer, Math.abs(a-b));
            board[wires[i][0] - 1][wires[i][1] - 1] = true;
            board[wires[i][1] - 1][wires[i][0] - 1] = true;
        }
        return answer;
    }
    static void dfs(int num) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] || !board[num][i]) {
                continue;
            }
            visited[i] = true;
            dfs(i);
            length++;
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
        System.out.println(solution(4, new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }
}
