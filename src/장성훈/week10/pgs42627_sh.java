package 장성훈.week10;

import java.util.*;
public class pgs42627_sh {
    public static void main(String[] args) {
//        〉	[[0, 10], [4, 10], [5, 11], [15, 2]]
        int[][] arr = new int[][] {
                {0,10},
                {4,10},
                {5,11},
                {15,2}
        };
        System.out.println(solution(arr));
    }

    public static int solution(int[][] jobs) {

//        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        Queue<int[]> todo = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Queue<int[]> doing = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] job : jobs) {
            todo.offer(job);
        }

        int now = 0;
        int total = 0;

        while (!todo.isEmpty() || !doing.isEmpty()) {
            while (!todo.isEmpty() && now >= todo.peek()[0]) {
                int[] job = todo.poll();
                doing.offer(job);
            }

            if (!doing.isEmpty()) {
                int[] job = doing.poll();

                total += now - job[0] + job[1];
                now += job[1];
//                total += now + job[1];
//                now += job[1];
            } else {
                now = todo.peek()[0];
            }
        }



//        Queue<int[]> pq = new PriorityQueue<>( (o1, o2) -> {
//            if ( (o1[0]+o1[1]) == (o2[0]+o2[1]) ) {
//                return o1[0]-o2[0];
//            }
//            return (o1[0]+o1[1]) - (o2[0]+o2[1]);
//        } );
//
//        for (int[] job : jobs) {
//            pq.offer(job);
//        }
//
//        int[] first = pq.poll();
//        int now = first[1];
//        int wait = 0;
//        while (!pq.isEmpty()) {
//            int[] curr = pq.poll();
//            int start = curr[0];
//            int work = curr[1];
//
//            if (start >= now) {
//                now = start;
//            } else {
//                wait += now - start;
//            }
//            now += work;
//            wait += work;
//        }
//
//        return wait/jobs.length;
        System.out.println(total);
        return total/jobs.length;
    }
}
