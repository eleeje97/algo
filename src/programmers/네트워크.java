package programmers;

import java.util.HashSet;
import java.util.Set;

public class 네트워크 {
    static int[] parents;
    static Set<Integer> set;
    public static int solution(int n, int[][] computers) {
        parents = new int[n];
        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j)continue;
                if(computers[i][j] == 1)
                union(i,j);
            }
        }
        //
        for (int i = 0; i < n; i++) {
            find(i);
        }
        for (int i = 0; i < n; i++) {
            set.add(parents[i]);
        }
        return set.size();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b){
            parents[b] = a;
        }
        else{
            parents[a] = b;
        }
    }
    private static int find(int a){
        if(parents[a] == a){
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
