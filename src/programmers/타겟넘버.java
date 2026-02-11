package programmers;

public class 타겟넘버 {

    static int length;
    static int goal;
    static int answer;
    static boolean[] visited;

    public static int solution(int[] numbers, int target) {
        length = numbers.length;
        goal = target;
        answer = 0;
        visited = new boolean[length];
        dfs(0, target, numbers);
        return answer;
    }

    static void dfs(int depth, int target, int[] numbers) {
        if (depth >= length) {
            int temp = 0;
            for (int i = 0; i < length; i++) {
                if (visited[i]) {
                    temp += numbers[i];
                } else {
                    temp -= numbers[i];
                }
            }
            if(temp == target) answer++;
            return;
        }
        visited[depth] = true;
        dfs(depth + 1, target, numbers);
        visited[depth] = false;
        dfs(depth + 1, target, numbers);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }

}
