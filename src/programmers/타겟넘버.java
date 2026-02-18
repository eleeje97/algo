package programmers;

public class 타겟넘버 {

    int[] value_numbers;
    int value_target;
    int count;


    public int solution(int[] numbers, int target) {

        count = 0;
        value_numbers = numbers;
        value_target = target;
        dfs(0,0);

        return count;
    }

    void dfs(int index, int sum) {

        if (index == value_numbers.length) {
            if (sum == value_target) {count++;}
            return;
        }

        int current = value_numbers[index];
        dfs(index + 1, sum + current);
        dfs(index + 1, sum - current);
    }

    void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;

        System.out.println(solution(numbers1, target1));
        System.out.println(solution(numbers2, target2));
    }
}