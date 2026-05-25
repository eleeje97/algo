package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 빛의경로사이클 {

    static int n, m;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][][] visited;

    public static int[] solution(String[] grid) {

        n = grid.length;
        m = grid[0].length();

        visited = new boolean[n][m][4];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {

                    if (!visited[i][j][d]) {
                        list.add(move(grid, i, j, d));
                    }
                }
            }
        }

        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    static int move(String[] grid, int x, int y, int dir) {

        int cnt = 0;

        while (!visited[x][y][dir]) {

            visited[x][y][dir] = true;
            cnt++;

            // 방향 변경
            char c = grid[x].charAt(y);

            if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            }

            // 이동
            x = (x + dx[dir] + n) % n;
            y = (y + dy[dir] + m) % m;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SL", "LR"}));
        System.out.println(solution(new String[]{"S"}));
        System.out.println(solution(new String[]{"R", "R"}));
    }
}
