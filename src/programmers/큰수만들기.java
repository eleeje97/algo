package programmers;

import java.util.Stack;

public class 큰수만들기 {

    public String solution(String number, int k) {

        Stack<Integer> strings = new Stack<>();
        int place_value = k;

        for (int i = 0; i < number.length(); i++) {
            int digit = number.charAt(i) - '0'; //Integer.parseInt보다 성능 우수

            while (!strings.isEmpty() && place_value > 0 && strings.peek() < digit) {
                strings.pop();
                place_value--;
            }
            strings.push(digit);
        }

        while (place_value > 0) {
            strings.pop();
            place_value--;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : strings) {
            sb.append(num);
        }

        return sb.toString();
    }

//    void dfsRemove(String number, int idx, int removed, int k, boolean[] removedFlag) {
//        if (removed == k) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < number.length(); i++) {
//                if (!removedFlag[i]) sb.append(number.charAt(i));
//            }
//            max = max.compareTo(sb.toString()) < 0 ? sb.toString() : max;
//            return;
//        }
//
//        if (idx == number.length()) return;
//
//        removedFlag[idx] = true;
//        dfsRemove(number, idx + 1, removed + 1, k, removedFlag);
//        removedFlag[idx] = false;
//
//        dfsRemove(number, idx + 1, removed, k, removedFlag);
//    }

    void main(String[] args) {
        String number1 = "1924";
        int k1 = 2;
        String number2 = "1231234";
        int k2 = 3;
        String number3 = "4177252841";
        int k3 = 4;

        System.out.println(solution(number1,k1));
        System.out.println(solution(number2,k2));
        System.out.println(solution(number3,k3));
    }
}