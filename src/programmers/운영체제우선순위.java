package programmers;

import java.util.*;

public class 운영체제우선순위 {
    public static long[] solution(int[][] program) {
        long[] answer = new long[11];

        Arrays.sort(program, (a, b) -> a[1] - b[1]); //호출시간으로 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; //우선순위 작은 순
            return a[1] - b[1]; // 같다면 호출시간 작은 순
        });

        long time = 0;
        int num = 0;
        int n = program.length;

        while (num < n || !pq.isEmpty()) {

            while (num < n && program[num][1] <= time) {
                pq.offer(program[num]);
                num++;
            }

            if (pq.isEmpty()) {
                time = program[num][1];
                continue;
            }

            int[] cur = pq.poll();

            int priority = cur[0];
            int callTime = cur[1];
            int runTime = cur[2];

            answer[priority] += time - callTime;

            time += runTime;
        }

        answer[0] = time;

        return answer;
    }

    public static void main(String[] args) {
        int[][] program = {{2,0,10},{1,5,5},{3,5,3},{3,12,2}};
        int[][] program2 = {{3,6,4},{4,2,5},{1,0,5},{5,0,5}};
        System.out.println(Arrays.toString(solution(program)));
        System.out.println(Arrays.toString(solution(program2)));
    }
}
