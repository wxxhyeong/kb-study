package 조우형.week13;

import java.util.*;
public class pgs12927_wh {

    public long solution(int n, int[] works) {
        long answer = 0;

        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for (int work : works) {
            pq.add(work);
        }

        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                return 0;
            }

            int cur = pq.poll() -1;
            if (cur != 0) {
                pq.add(cur);
            }
        }

        for (Integer i : pq) {
            answer += i*i;
        }

        return answer;
    }
}
