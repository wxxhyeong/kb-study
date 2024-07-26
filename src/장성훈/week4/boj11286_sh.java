package 장성훈.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj11286_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 절대값 비교를 위해 comparator 구현
        Comparator<Integer> comparator = (o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            // 절대값이 작은게 왼쪽으로
            if (abs1 != abs2) {
                return abs1 - abs2;
            }

            // 절대값이 같다면 실제로 작은 값이 왼쪽으로
            return o1 - o2;
        };
        
        // 절대값 비교를 위한 PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);

        // 결과값 출력
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(input);
            }
        }
        System.out.println(sb.toString());
    }
}
