package programmers;


import java.util.Arrays;

public class 구명보트 {

    public int solution(int[] people, int limit) {

        //최대한 limit 채우기 위해서
        Arrays.sort(people);

        //two pointer 블로그 참고
        int left = 0;
        int right = people.length - 1;
        int count = 0;

        while (left <= right) {

            count++;

            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
        }

        return count;
    }


    void main(String[] args) {
        int[] people1 = {70,50,80,50};
        int limit1 = 100;
        int[] people2 = {70,80,50};
        int limit2 = 100;

        System.out.println(solution(people1, limit1));
        System.out.println(solution(people2, limit2));
    }
}