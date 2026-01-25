package programmers;

import java.util.Arrays;

public class 섬연결하기 {
    static int[] parents;
    public static int solution(int n, int[][] costs) {
        // init
        int answer = 0;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        // 비용 오름차순
        // 애초에 알고리즘 자체가 최저비용인 간선을 택하는 방식이라 정렬 필수
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2],o2[2]));
        // 합칠수 있다면 합
        for (int[] cost : costs) {
            if (union(cost[0], cost[1])) {
                answer += cost[2];
            }
        }
        return answer;
    }

    // 부모를 찾고 찾는 과정에서 경로압축 진행
    static int find(int a){
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
    // 합쳐지면 true, 아니면 false
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        // 이미 연결되어있음
        if (a == b) {
            return false;
        }
        // 낮은 번호로 합치기
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }
}
