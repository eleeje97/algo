package programmers;

import java.util.Arrays;

public class 입국심사 {
    static long start,end,mid;
    static long[] ltimes;
    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        start = 0;
        end = 1_000_000_000L * 100_000L;
        mid = end / 2;
        ltimes = new long[times.length];
        for (int i = 0; i < times.length; i++) {
            ltimes[i] = times[i];
        }
        while (start < end) {
            long cnt = 0;
            for (long ltime : ltimes) {
                cnt += mid / ltime;
            }
            if (cnt >= n) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }

        return start;
    }
    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{7,10}));
        System.out.println(solution(1,new int[]{1}));
        System.out.println(solution(59,new int[]{1,1}));
    }
}
