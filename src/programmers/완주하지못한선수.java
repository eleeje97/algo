package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        완주하지못한선수 sol = new 완주하지못한선수();
        System.out.println(sol.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"})); // leo
        System.out.println(sol.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"})); // vinko
        System.out.println(sol.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"})); // mislav
    }
}
