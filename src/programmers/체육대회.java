package programmers;

public class 체육대회 {
    static int answer;
    static boolean[] visited;

    public static int solution(int[][] ability) {
        int studentCount = ability.length;
        int sportCount = ability[0].length;

        answer = 0;
        visited = new boolean[studentCount];

        dfs(ability, 0, 0, sportCount, studentCount);

        return answer;
    }

    static void dfs(int[][] ability, int depth, int sum, int sportCount, int studentCount) {
        if (depth == sportCount) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            if (!visited[i]) {
                visited[i] = true;

                dfs(
                        ability,
                        depth + 1,
                        sum + ability[i][depth],
                        sportCount,
                        studentCount
                );

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ability = {{40,10,10},{20,5,0},{30,30,30},{70,0,70},{100,100,100}};
        int[][] ability2 = {{20,30},{30,20},{20,30}};
        System.out.println(solution(ability));
        System.out.println(solution(ability2));
    }
}
