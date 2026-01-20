package programmers;

public class 피로도 {
    //    8:22~9:08
    static int answer;
    static int maxRecursion;
    static boolean[] visited;

    public static int solution(int k, int[][] dungeons) {
        // init
        answer = 0;
        maxRecursion = dungeons.length;
        visited = new boolean[maxRecursion];

        recur(0, k, 0, dungeons);
        return answer;
    }

    public static void recur(int depth, int tired, int idx, int[][] dungeons) {
        // 끝에 도달, 남은피로 < 최소필요
        if (depth == maxRecursion) {
            answer = maxRecursion;
            return;
        }
        for (int i = 0; i < maxRecursion; i++) {
            if (visited[i] || tired < dungeons[i][0]) {
                continue;
            }
            answer = Math.max(answer, depth + 1);
            visited[i] = true;
            recur(depth + 1, tired - dungeons[i][1], i, dungeons);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
