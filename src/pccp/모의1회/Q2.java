package pccp.모의1회;

public class Q2 {
    int eventLength = 0;
    int answer = 0;

    public int solution(int[][] ability) {
        answer = 0;
        eventLength = ability[0].length;
        dfs(ability, new boolean[ability.length], 0, 0);

        return answer;
    }

    public void dfs(int[][] ability, boolean[] selected, int count, int sum) {
        if (count == eventLength) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            dfs(ability, selected, count + 1, sum + ability[i][count]);
            selected[i] = false;
        }
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(q2.solution(new int[][]{{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}})); // 210
        System.out.println(q2.solution(new int[][]{{20, 30}, {30, 20}, {20, 30}})); // 60
    }
}
