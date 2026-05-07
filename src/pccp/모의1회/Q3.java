package pccp.모의1회;

import java.util.Arrays;

public class Q3 {
    String[] bean = {"rr", "RR", "Rr", "Rr"};

    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = func(queries[i][0] - 2, queries[i][1]);
        }

        return answer;
    }

    public String func(int n, int p) {
        if (n == -1) {
            return "Rr";
        }

        while (n > 0) {
            int group = p / (int) Math.pow(4, n) + 1;
            if (group == 1) {
                return "RR";
            }

            if (group == 4) {
                return "rr";
            }

            p = p % (int) Math.pow(4, n);
            n--;
        }

            return bean[p];
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(Arrays.toString(q3.solution(new int[][]{{3, 5}}))); // [RR]
        System.out.println(Arrays.toString(q3.solution(new int[][]{{3, 8}, {2, 2}}))); // [rr, Rr]
        System.out.println(Arrays.toString(q3.solution(new int[][]{{3, 1}, {2, 3}, {3, 9}}))); // [RR, Rr, RR]
        System.out.println(Arrays.toString(q3.solution(new int[][]{{4, 26}}))); // [Rr]

    }
}
