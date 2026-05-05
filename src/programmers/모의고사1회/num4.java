package programmers.모의고사1회;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class num4 {
    static long[] answer;
    static Queue<int[]> q;
    static PriorityQueue<int[]> pq;
    public static long[] solution(int[][] program) {
        answer = new long[11];
        q = new LinkedList<>();
        // 호출시간 별 정렬
        Arrays.sort(program, (Comparator.comparingInt(o -> o[1])));
        // 큐에 넣기
        for (int i = 0; i < program.length; i++) {
            q.offer(program[i]);
        }
        // 1순위 호출시간, 2순위 우선순위 정렬
        pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        int time = 0;
        while (!q.isEmpty() || !pq.isEmpty()) {
            // pq 비어있으면 q에서 가장빠른 시간으로 당김
            if (pq.isEmpty()&& q.peek()[1] > time) {
                time = q.peek()[1];
            }
            // 같은 시간 q 모두 뺌
            while (!q.isEmpty() && q.peek()[1] <= time) {
                int[] next = q.poll();
                pq.offer(next);
            }

            // pq에서 하나 빼서 작업 진행
            int[] next = pq.poll();
            int a = next[0];
            int b = next[1];
            int c = next[2];
            // 현재시간 - 호출시간 값 저장
            answer[a] += time - b;
            // 작업실행 시 현재시간에서 실행시간만큼 +
            time += c;
        }
        answer[0] = time;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2,0,10},{1,5,5},{3,5,3},{3,12,2}}));
        System.out.println(solution(new int[][]{{3,6,4},{4,2,5},{1,0,5},{5,0,5}}));
    }
}
