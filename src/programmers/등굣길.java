package programmers;

public class 등굣길 {
    static final int MOD = 1_000_000_007;

    public static int solution(int m, int n, int[][] puddles) {
        int[][] ways = new int[n + 1][m + 1];
        boolean[][] Puddle = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            Puddle[y][x] = true;
        }

        ways[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {

                if (x == 1 && y == 1) continue;

                if (Puddle[y][x]) {
                    ways[y][x] = 0;
                    continue;
                }

                int fromUp = 0;
                int fromLeft = 0;

                if (y > 1) fromUp = ways[y - 1][x];

                if (x > 1) fromLeft = ways[y][x - 1];

                ways[y][x] = (fromUp + fromLeft) % MOD;
            }
        }

        return ways[n][m];
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(solution(m, n, puddles));
    }
}