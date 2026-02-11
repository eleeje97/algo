package programmers;

public class 큰수만들기 {
    public static String solution(String number, int k) {
        // 1. 0부터 number 맨끝 -k번째 인덱스까지 제일 큰 수 찾아
        // 2. 해당 인덱스만큼 여유분에서 제외 후 나머지 찾음
        String answer = "";
        int start = 0;
        int end = number.length() - k;

        while (answer.length() < number.length() - k) {
            int max = -1;
            int maxIdx = start;

            for (int i = start; i <= k + answer.length(); i++) {
                int cur = number.charAt(i) - '0';
                if (cur > max) {
                    max = cur;
                    maxIdx = i;
                }
            }

            answer += number.charAt(maxIdx);
            start = maxIdx + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution("1924",2));
        System.out.println(solution("1231234",3));
        System.out.println(solution("4177252841",4));
    }
}
