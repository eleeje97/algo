package programmers;

import java.util.Arrays;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";

        int[] array = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        answer += Arrays.stream(array).min().getAsInt();
        answer += " ";
        answer += Arrays.stream(array).max().getAsInt();

        return answer;
    }


    public static void main(String[] args) {
        최댓값과최솟값 sol = new 최댓값과최솟값();
        System.out.println(sol.solution("1 2 3 4")); // 1 4
        System.out.println(sol.solution("-1 -2 -3 -4")); // -4 -1
        System.out.println(sol.solution("-1 -1")); // -1 -1
    }
}
