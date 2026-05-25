package programmers;

import java.util.*;

public class 빛의경로 {
    public static int[] solution(String[] grid) {
        ArrayList<Integer> answerList = new ArrayList<>();

        int rowSize = grid.length;
        int colSize = grid[0].length();


        HashSet<String> visited = new HashSet<>();

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                for (int dir = 0; dir < 4; dir++) {

                    String startKey = row + "," + col + "," + dir;

                    if (visited.contains(startKey)) {
                        continue;
                    }

                    int length = moveLight(grid, visited, row, col, dir);
                    answerList.add(length);
                }
            }
        }

        Collections.sort(answerList);

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static int moveLight(String[] grid, HashSet<String> visited, int startRow, int startCol, int startDir) {
        int rowSize = grid.length;
        int colSize = grid[0].length();

        int row = startRow;
        int col = startCol;
        int dir = startDir;

        int count = 0;

        while (true) {
            String key = row + "," + col + "," + dir;

            if (visited.contains(key)) {
                break;
            }

            visited.add(key);

            char currentCell = grid[row].charAt(col);

            if (currentCell == 'S') {
            } else if (currentCell == 'L') {
                if (dir == 0) {
                    dir = 3;
                } else if (dir == 1) {
                    dir = 0;
                } else if (dir == 2) {
                    dir = 1;
                } else if (dir == 3) {
                    dir = 2;
                }
            } else if (currentCell == 'R') {
                if (dir == 0) {
                    dir = 1;
                } else if (dir == 1) {
                    dir = 2;
                } else if (dir == 2) {
                    dir = 3;
                } else if (dir == 3) {
                    dir = 0;
                }
            }

            if (dir == 0) {
                row--;
            } else if (dir == 1) {
                col++;
            } else if (dir == 2) {
                row++;
            } else if (dir == 3) {
                col--;
            }

            if (row < 0) {
                row = rowSize - 1;
            }

            if (row >= rowSize) {
                row = 0;
            }

            if (col < 0) {
                col = colSize - 1;
            }

            if (col >= colSize) {
                col = 0;
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String[] grid1 = {"SL","LR"};
        String[] grid2 = {"S"};
        String[] grid3 = {"R","R"};

        System.out.println(Arrays.toString(빛의경로.solution(grid1)));
        System.out.println(Arrays.toString(빛의경로.solution(grid2)));
        System.out.println(Arrays.toString(빛의경로.solution(grid3)));
    }
}
