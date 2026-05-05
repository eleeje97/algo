package programmers.모의고사1회;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num3 {
    static Stack<Integer> stack;
    static List<String> answerList;
    public static String[] solution(int[][] queries) {
        // -1해주고 4로 나눠
        // 나머지를 역순으로 넣어준다
        // n만큼 진행
        answerList = new ArrayList<>();
        for (int[] query : queries) {
            stack = new Stack<>();
            int n = query[0];
            int p = query[1];
            p--;
            int num = p; // 몫 담을 변수
            for (int i = 0; i < n-1; i++) {
                stack.push(num % 4);
                num /= 4;
            }
            if (n == 0) {
                answerList.add("Rr");
            }
            else {
                dfs(1,n, "Rr");
            }
        }
        String[] answers = new String[queries.length];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = answerList.get(i);
        }
        return answers;
    }
    static void dfs(int depth, int goal, String now){
        if (depth == goal) {
            answerList.add(now);
            return;
        }
        int num = stack.pop();
        if (now.equals("RR")) {
            dfs(depth + 1, goal, "RR");
        } else if (now.equals("Rr")) {
            if (num == 0) {
                dfs(depth + 1, goal, "RR");
            } else if (num==1) {
                dfs(depth + 1, goal, "Rr");
            } else if (num == 2) {
                dfs(depth + 1, goal, "Rr");
            } else {
                dfs(depth + 1, goal, "rr");
            }
        } else {
            dfs(depth + 1, goal, "rr");
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3,1},{2,3},{3,9}}));
        System.out.println(solution(new int[][]{{3,8},{2,2}}));
        System.out.println(solution(new int[][]{{3,5}}));
        System.out.println(solution(new int[][]{{4,26}}));
    }
}
