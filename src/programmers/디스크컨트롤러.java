package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static int solution(int[][] jobs) {

        //우선순위 정렬
        PriorityQueue<Job> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.duration != b.duration)
                        return a.duration - b.duration;
                    if (a.requestTime != b.requestTime)
                        return a.requestTime - b.requestTime;
                    return a.id - b.id;
                }
        );

        //반칙;;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int time = 0;
        int count = 0;
        int job_id = 0;
        int return_time = 0;


        while (count < jobs.length) {

            while (job_id < jobs.length && jobs[job_id][0] <= time) {
                pq.add(new Job(job_id, jobs[job_id][0], jobs[job_id][1]));
                job_id++;
            }

            if (!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.duration;   // 작업 수행
                return_time += time - job.requestTime;
                count++;
            } else {
                time++;
            }
        }

        return return_time/jobs.length;

    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};

        System.out.println(solution(jobs));
    }

    static class Job {
        int id;
        int requestTime;
        int duration;

        public Job(int id, int requestTime, int duration) {
            this.id = id;
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }
}
