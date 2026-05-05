package programmers.모의고사1회;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class num1 {
    static HashMap<Character,Integer> hm;
    static LinkedHashSet<Character> set;
    static char beforeChar;
    static ArrayList<Character> sortedList;

    public static String solution(String input_string) {
        String answer = "";
        set = new LinkedHashSet<>();
        hm = new HashMap<>();

        beforeChar = input_string.charAt(0);
        for (int i = 0; i < input_string.length(); i++) {
            char now = input_string.charAt(i);
            if (beforeChar != now && hm.containsKey(now)) {
                set.add(now);
            }
            else{
                hm.put(now, 0);
            }
            beforeChar = now;
        }
        // sort
        sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        for (char c : sortedList) {
            answer += c;
        }

        return answer.isEmpty() ? "N":answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("edeaaabbccd"));
        System.out.println(solution("eeddee"));
        System.out.println(solution("string"));
        System.out.println(solution("zbzbz"));
    }
}
