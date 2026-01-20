package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 섬연결하기 {
    int[][] connectedMap;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int connected = n;

        // cost가 작은 순으로 정렬
        List<Cost> costList = new ArrayList<>();
        for (int[] cost : costs) {
            costList.add(new Cost(cost[0], cost[1], cost[2]));
        }
        Collections.sort(costList);

        // 자기 자신과는 연결되었다고 표시
        connectedMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            connectedMap[i][i] = 1;
        }

        for (Cost cost : costList) {
            // 모든 섬이 연결됐는지 체크
            if (connected == n * n) {
                break;
            }

            // 이미 연결되어 있으면 패스
            if (connectedMap[cost.i][cost.j] == 1) {
                continue;
            }

            answer += cost.cost;
            List<Integer> iList = getConnectedIsland(cost.i, n);
            List<Integer> jList = getConnectedIsland(cost.j, n);

            // i와 연결된 모든 섬에 j와 연결된 모든 섬 추가
            for (int island : iList) {
                for (int neighbor : jList) {
                    connectedMap[island][neighbor] = 1;
                    connected++;
                }
            }

            // j와 연결된 모든 섬에 i와 연결된 모든 섬 추가
            for (int island : jList) {
                for (int neighbor : iList) {
                    connectedMap[island][neighbor] = 1;
                    connected++;
                }
            }
        }

        return answer;
    }

    public List<Integer> getConnectedIsland(int islandNum, int totalNum) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < totalNum; i++) {
            if (connectedMap[islandNum][i] == 1) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        섬연결하기 sol = new 섬연결하기();
        System.out.println(sol.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
        System.out.println(sol.solution(4, new int[][]{{0,1,1},{0,2,1},{1,2,1},{1,3,1},{2,3,8}}));
        System.out.println(sol.solution(5, new int[][]{{1,2,3},{0,1,1},{0,4,5},{2,4,1},{2,3,1},{3,4,1}}));
        System.out.println(sol.solution(5, new int[][]{{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4},{2,4,6},{4,0,7}}));
        System.out.println(sol.solution(5, new int[][]{{0,1,1},{2,3,1},{3,4,2},{1,2,2},{0,4,100}}));
        System.out.println(sol.solution(4, new int[][]{{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4}}));
        System.out.println(sol.solution(4, new int[][]{{0,1,1},{0,2,2},{2,3,1}}));
        System.out.println(sol.solution(7, new int[][]{{1,0,1},{3,2,1},{4,5,1},{3,5,9},{3,6,10},{1,6,1},{6,5,1}}));
        System.out.println(sol.solution(6, new int[][]{{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10},{1,2,2},{2,5,3},{4,5,4}}));
        System.out.println(sol.solution(6, new int[][]{{0,1,1},{3,1,1},{2,3,3},{2,4,4},{5,4,5}}));
        System.out.println(sol.solution(5, new int[][]{{0,1,1},{3,4,1},{1,2,2},{2,3,4}}));
    };
}

class Cost implements Comparable<Cost> {
    int i;
    int j;
    int cost;

    public Cost(int i, int j, int cost) {
        this.i = i;
        this.j = j;
        this.cost = cost;
    }

    @Override
    public int compareTo(Cost other) {
        return cost - other.cost;
    }
}
