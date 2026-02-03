package programmers;

public class 모음사전 {

    String[] vowels = {"A", "E", "I", "O", "U"};
    int count = 0;
    int answer = 0;
    boolean found = false;

    public int solution(String word) {
        count = 0;
        answer = 0;
        found = false;

        dfs("", word);
        return answer;
    }

    void dfs(String current, String target) {
        if (current.length() > 5 || found) return;

        if (!current.isEmpty()) {
            count++;
            if (current.equals(target)) {
                answer = count;
                found = true;
                return;
            }
        }

        for (String v : vowels) {
            dfs(current + v, target);
        }
    }

    void main(String[] args) {
        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        System.out.println(solution(word1));
        System.out.println(solution(word2));
        System.out.println(solution(word3));
        System.out.println(solution(word4));
    }
}