package pccp.모의1회;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Q1 {
    public String solution(String input_string) {
        StringBuilder answer = new StringBuilder();
        char current = input_string.charAt(0);
        Map<Character, Integer> map = new HashMap<>();
        map.put(current, 1);

        for (int i = 1; i < input_string.length(); i++) {
            char c = input_string.charAt(i);
            if (c != current) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            current = c;
        }

        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                answer.append(entry.getKey());
            }
        }

        return answer.length() == 0 ? "N" : answer.toString();
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.solution("edeaaabbccd")); // de
        System.out.println(q1.solution("eeddee")); // e
        System.out.println(q1.solution("string")); // N
        System.out.println(q1.solution("zbzbz")); // bz

    }
}
