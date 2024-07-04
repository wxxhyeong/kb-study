package 김민지.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] incomes = new long[N + 1];

        // 일급
        st = new StringTokenizer(br.readLine());
        incomes[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            incomes[i] = incomes[i-1] + Long.parseLong(st.nextToken());
        }

        // 투포인터
        int startP = 0, endP = M;
        long max_total = 0;;
        while (endP <= N) {
            long sum = incomes[endP] - incomes[startP];

            if (sum > max_total) {
                max_total = sum;
            }

            startP++;
            endP++;
        }

        System.out.println(max_total);
    }
}
