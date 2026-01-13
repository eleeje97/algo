package programmers;

import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num)
                stack.push(num);
        }

        int[] answer = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        같은숫자는싫어 sol = new 같은숫자는싫어();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 1, 3, 3, 0, 1, 1}))); // [1,3,0,1]
        System.out.println(Arrays.toString(sol.solution(new int[]{4, 4, 4, 3, 3}))); // [4,3]
    }
}