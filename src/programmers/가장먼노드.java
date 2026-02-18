package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 가장먼노드 {
    static PriorityQueue<Node> pq;
    static final int INF = 987654321;
    static ArrayList<Integer>[] connect;
    static int[] distance;
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.dist, o2.dist)));
        distance = new int[n];
        connect = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            distance[i] = INF;
            connect[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            connect[e[0]-1].add(e[1]-1);
            connect[e[1]-1].add(e[0]-1);
        }
        distance[0] = 0;
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            // 이미 방문처리 끝
            if (node.dist > distance[node.n]) {
                continue;
            }
            // 연결되어있는 노드를 확인
            for (int next : connect[node.n]) {
                // 비용을 줄일 수 있다면 pq에 넣는다
                if (distance[next] > node.dist + 1) {
                    distance[next] = node.dist + 1;
                    pq.offer(new Node(next, node.dist + 1));
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, distance[i]);
        }
        for (int i = 0; i < n; i++) {
            if (maxValue == distance[i]) {
                answer++;
            }
        }
        return answer;
    }
    static class Node{
        int n, dist;

        public Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
