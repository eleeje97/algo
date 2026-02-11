package programmers;

import java.util.Arrays;

public class 구명보트 {

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int start = 0;
        int end = people.length - 1;
        while (true) {
            if (start >= end) {
                if (start == end) {
                    answer++;
                    break;
                }
                break;
            }
            if (people[start] + people[end] > limit) {
                answer++;
                end--;
            } else {
                answer++;
                start++;
                end--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }
}
