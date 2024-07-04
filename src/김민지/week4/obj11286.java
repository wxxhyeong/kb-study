package 김민지.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class obj11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> arr = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs)
                return o1 > o2 ? 1 : -1;
            else
                return first_abs - second_abs;
        });

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            // 가장 작은 값 출력하기
            if (a == 0) {
                if (arr.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(arr.poll());
                continue;
            }

            arr.add(a);
        }
    }
}
