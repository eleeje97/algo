package programmers;

import java.util.Arrays;

public class 최대값과최소값 {

    public static String solution(String s) {

        String[] array = s.split(" ");
        int[] intArray = Arrays.stream(array).mapToInt(value -> Integer.parseInt(value)).toArray();
        Arrays.sort(intArray);
        return intArray[0] + " " + intArray[intArray.length - 1];
    }

    public static void main(String[] args) {
//        solution("1 2 3 4");
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }
}
