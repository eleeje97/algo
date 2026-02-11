package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> q;
    static int n, m;

    public static int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        board = new int[n][m];
        visited = new boolean[n][m];
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = maps[i][j];
            }
        }
        // 1. 일단 큐에 시작점 넣음
        q.offer(new Node(0, 0));
        visited[0][0] = true;
        int time = 1;
        // 2. 큐가 모두 빌때까지 진행
        while (!q.isEmpty()) {
            int size = q.size();
            // 현재 큐 사이즈만큼만 진행
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                // 종료시점
                if (node.x == n - 1 && node.y == m - 1) {
                    answer = time;
                }
                // 사방탐색 진행
                for (int j = 0; j < 4; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    // 범위초과 & 이미 방문한곳 && 벽 제외
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]|| board[nx][ny] == 0) {
                        continue;
                    }
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            time++;
        }
        return answer;
    }

    static class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(
                new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }
}
