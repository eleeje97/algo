package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {

    static PriorityQueue<int[]> pq;

    public static int solution(int[][] jobs) {
        // init
        int cnt = 0; // 작업수
        int idx = 0; // 인덱스
        int end = 0; // 작업이 끝난 시간
        int answer = 0;
        // 1. 요청시간 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        // 2. 처리시간 오름차순 정렬
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        while (cnt < jobs.length) {
            // 현재 시간 요청된 모든 작업을 pq에 넣어
            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.offer(jobs[idx++]);
            }
            // pq가 비어있으면 시간 이동
            if (pq.isEmpty()) {
                end = jobs[idx][0];
            }
            // 아니면 작업 시작
            else {
                int[] element = pq.poll();
                answer += end + element[1] - element[0];
                end += element[1];
                cnt++;
            }
        }
        return answer / jobs.length;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {3, 5}}));
    }
}
