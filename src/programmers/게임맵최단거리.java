package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    public int bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            if (x == maps.length - 1 && y == maps[0].length - 1) {
                return maps[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    maps[nx][ny] = maps[x][y] + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        게임맵최단거리 sol = new 게임맵최단거리();
        System.out.println(sol.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}})); // 11
        System.out.println(sol.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}})); // -1
    }
}
