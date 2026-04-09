package programmers;

public class 등굣길 {
    static int x, y;
    static int[][] board;
    static boolean[][] dontGo;
    static final int MODULAR = 1000000007;

    static public int solution(int m, int n, int[][] puddles) {
        x = n;
        y = m;
        board = new int[x + 1][y + 1];
        dontGo = new boolean[x + 1][y + 1];
        board[0][1] = 1;
        for (int i = 0; i < puddles.length; i++) {
            dontGo[puddles[i][1]][puddles[i][0]] = true;
        }
        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                // max(위쪽에 도달하는 경우의 수+왼쪽에 도달하는 경우의 수, 0)
                // 단, 웅덩이인 경우 0
                if (!dontGo[i][j]) {
                    board[i][j] = (board[i - 1][j] + board[i][j - 1]) % MODULAR;
                }
            }
        }
        return board[x][y];
    }

    public static void main(String[] args) {
        System.out.println(solution(4,3,new int[][]{{2,2}}));
    }
}
