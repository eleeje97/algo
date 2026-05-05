package programmers.모의고사1회;

public class num2 {
    static int students;
    static int abilities;
    static int answer;
    public static int solution(int[][] ability) {

        answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{40,10,10},{20,5,0},{30,30,30},{70,0,70},{100,100,100}}));
        System.out.println(solution(new int[][]{{20,30},{30,20},{20,30}}));
    }
}
