package programmers;

public class 타겟넘버 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int n, int sum) {
        if (n == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, n + 1, sum + numbers[n]);
        dfs(numbers, target, n + 1, sum - numbers[n]);
    }

    public static void main(String[] args) {
        타겟넘버 sol = new 타겟넘버();
        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(sol.solution(new int[]{4, 1, 2, 1}, 4)); // 2
    }
}
