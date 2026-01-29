package programmers;

import java.util.HashMap;

public class 모음사전 {
    static HashMap<String, Integer> hm;
    static char[] aeiou = {'A','E','I','O','U'};
    static int num;
    public static int solution(String word) {
        num = 0;
        hm = new HashMap<>();
        dfs(0, "");
        // Integer to int
        return hm.get(word);
    }
    static void dfs(int depth, String word){
        if (depth >= 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            String newWord = word + aeiou[i];
            hm.put(newWord, ++num);
            dfs(depth+1, newWord);
        }
    }
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));

    }
}
