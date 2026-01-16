package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 올바른괄호 {
    public static boolean solution(String s) {

        Stack<Character> strings = new Stack<>();
        boolean answer = true;

        for(int i=0; i < s.length();i++) {
            if (s.charAt(i) == '('){
                strings.push(s.charAt(i));
            }
            else if(!strings.isEmpty() && strings.peek() == '('){
                strings.pop();
            } else return false;
        }

        answer = strings.isEmpty();

        return answer;

    }

    public static void main(String[] args) {
        String one = "()()";
        String two = "(())()";
        String three = ")()(";
        String four = "(()(";

        System.out.println(solution(one));
        System.out.println(solution(two));
        System.out.println(solution(three));
        System.out.println(solution(four));
    }
}
