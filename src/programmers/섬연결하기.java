package programmers;

import java.util.Arrays;

public class 섬연결하기 {

    int[] island;

    //대표 찾기
    int find(int x) {
        if (island[x] == x) return x;
        return island[x] = find(island[x]);
    }

    boolean connect(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        island[rootB] = rootA;
        return true;
    }

    public int solution(int n, int[][] costs) {

        //비용 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        //꼬리표 달기
        island = new int[n];
        for (int i = 0; i < n; i++) {
            island[i] = i;
        }

        int totalCost = 0;
        int edgeCount = 0;

        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int costValue = cost[2];

            if (connect(island1, island2)) {
                totalCost += costValue;
                edgeCount++;

                //다리갯수가 n(섬)-1이면 전부 연결됨
                if (edgeCount == n - 1) break;
            }
        }

        return totalCost;
    }


    void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(solution(n,costs));
    }
}