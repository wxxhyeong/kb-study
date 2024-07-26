package 조우형.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj11286_wh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if (abs1 > abs2) {
                    return 1;
                }
                else if (abs1 < abs2) {
                    return -1;
                }
                else {
                    if (o1 <= o2) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        };


        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());

            if (v != 0){
                pq.add(v);
                continue;
            }

            cnt++;
            while (cnt > 0) {
                cnt--;
                int temp;

                if (!pq.isEmpty()) {
                    temp = pq.poll();
                    sb.append(temp + "\n");
                }
                else {
                    sb.append(0 + "\n");
                }
            }
        }

        System.out.println(sb.toString());

    }
}
