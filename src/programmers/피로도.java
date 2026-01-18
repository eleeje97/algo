package programmers;

import java.util.*;

public class 피로도 {

    boolean[] visited;
    int[][] dungeons;
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        dfs(k, 0);
        return answer;
    }

    void dfs(int fatigue, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(fatigue - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }

    void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{0, 3}, {1, 9}, {3, 5}};

        System.out.println(solution(k,dungeons));
    }
}