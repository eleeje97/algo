package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {

        String answer = "";

        Map<String, Integer> countRunner = new HashMap<>();

        for(String runner : participant) {
            countRunner.put(runner, countRunner.getOrDefault(runner,0)+1);
        }

        for (String completedRunner : completion) {
            countRunner.put(completedRunner, countRunner.getOrDefault(completedRunner,0) -1);
        }

        for (Map.Entry<String, Integer> entry : countRunner.entrySet()) {
            if (entry.getValue() > 0) answer = entry.getKey();
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String result = 완주하지못한선수.solution(participant, completion);

        System.out.println(result);
    }
}
