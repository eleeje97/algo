package programmers;

public class 입국심사 {
    public static long solution(int n, int[] times) {
        long maxTime = 0;
        for (int t : times) {
            if (t > maxTime) maxTime = t;
        }

        long left = 0;
        long right = maxTime * (long) n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (int t : times) {
                cnt += mid/t;
            }

            if (cnt >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};

        System.out.println(solution(n,times));
    }
}
