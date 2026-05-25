package programmers;

import java.util.*;

public class 외톨이알파벳 {
    public static String solution(String input_string) {
        Set<Character> seen = new HashSet<>();
        Set<Character> alone = new TreeSet<>(); // TreeSet 유니코드/문자 코드 순서로 정렬해줌

        char prev = input_string.charAt(0);
        seen.add(prev);

        for (int i = 1; i < input_string.length() ; i++) {
            char c = input_string.charAt(i);
            if (seen.contains(c)) {
                if (c != prev) {
                    alone.add(c);
                }
            } else {
                seen.add(c);
            }
            prev = c;
        }

        if (alone.isEmpty()) {
            return "N";
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : alone) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input_string = "edeaaabbccd";
        String input_string2 = "eeddee";
        String input_string3 = "string";
        String input_string4 = "zbzbz";
        System.out.println(solution(input_string));
        System.out.println(solution(input_string2));
        System.out.println(solution(input_string3));
        System.out.println(solution(input_string4));
    }
}
