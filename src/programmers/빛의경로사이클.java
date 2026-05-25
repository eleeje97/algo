package programmers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 빛의경로사이클 {
    Dot[][] dots;
    int cost;
    List<Integer> costs;

    public int[] solution(String[] grid) {
        costs = new ArrayList<>();
        dots = new Dot[grid.length][grid[0].length()];

        cost = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                dots[i][j] = new Dot(grid[i].charAt(j));
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                for (int k = 0; k < 4; k++) {
                    if (!dots[i][j].visited[k]) {
                        dots[i][j].visited[k] = true;
                        cost = 0;
                        cycle(i, j, k);
                    }
                }
            }
        }

        return costs.stream().mapToInt(v -> v).sorted().toArray();
    }

    void cycle(int i, int j, int direction) {
        while (true) {
            cost++;

            int nexti = 0;
            int nextj = 0;
            if (direction == 0) { // 위로
                nexti = i - 1;
                if (nexti < 0)
                    nexti = dots.length - 1;
                nextj = j;
            } else if (direction == 1) { // 오른쪽으로
                nexti = i;
                nextj = j + 1;
                if (nextj >= dots[0].length)
                    nextj = 0;
            } else if (direction == 2) { // 아래로
                nexti = i + 1;
                nextj = j;
                if (nexti >= dots.length)
                    nexti = 0;
            } else { // 왼쪽으로
                nexti = i;
                nextj = j - 1;
                if (nextj < 0)
                    nextj = dots[0].length - 1;
            }

            Dot next = dots[nexti][nextj];
            if (next.type == 'L') {
                direction--;
                if (direction < 0)
                    direction = 3;
            } else if (next.type == 'R') {
                direction++;
                if (direction >= 4)
                    direction = 0;
            }

            if (next.visited[direction]) {
                costs.add(cost);
                break;
            } else {
                next.visited[direction] = true;
                i = nexti;
                j = nextj;
            }
        }
    }

    class Dot {
        char type;
        boolean[] visited;

        Dot(char type) {
            this.type = type;
            visited = new boolean[4];
        }
    }

    public static void main(String[] args) {
        빛의경로사이클 sol = new 빛의경로사이클();
        System.out.println(Arrays.toString(sol.solution(new String[] {"SL", "LR"})));
        System.out.println(Arrays.toString(sol.solution(new String[] {"S"})));
        System.out.println(Arrays.toString(sol.solution(new String[] {"R", "R"})));
    }
}
