package programmers;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        올바른괄호 sol = new 올바른괄호();
        System.out.println(sol.solution("()()")); // true
        System.out.println(sol.solution("(())()")); // true
        System.out.println(sol.solution(")()(")); // false
        System.out.println(sol.solution("(()(")); // false
    }
}
