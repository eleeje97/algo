package programmers;

public class 최댓값과최솟값 {

    public String solution(String word) {
        String[] arr = word.split(" ");

        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);

            if(num<min) min = num;
            if(num>max) max = num;
        }


        return min + " " + max;
    }

    void main(String[] args) {
        String word1 = "1 2 3 4";
        String word2 = "-1 -2 -3 -4";
        String word3 = "-1 -1";

        System.out.println(solution(word1));
        System.out.println(solution(word2));
        System.out.println(solution(word3));
    }
}