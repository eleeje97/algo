package programmers;

public class 등굣길 {
    static boolean[][] map;
    static int[][] dp;

    public int solution(int m, int n, int[][] puddles) {
        map = new boolean[m + 1][n + 1];
        dp = new int[m + 1][n + 1];

        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = true;
        }

        dp[1][1] = 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 1) {
                    dp[i][j] += dp[i-1][j] % 1000000007;
                }

                if (j > 1) {
                    dp[i][j] += dp[i][j-1] % 1000000007;
                }
            }
        }

        return dp[m][n] % 1000000007;
    }

    public static void main(String[] args) {
        등굣길 sol = new 등굣길();
        System.out.println(sol.solution(4, 3, new int[][]{{2, 2}})); // 4
    }
}
