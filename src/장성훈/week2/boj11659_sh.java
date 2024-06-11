package 장성훈.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11659_sh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        List<Long> preFixSum = new ArrayList<>();
        long tempSum = 0;
        preFixSum.add(tempSum);
        for (long num : arr) {
            tempSum += num;
            preFixSum.add(tempSum);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            answer.append((preFixSum.get(end) - preFixSum.get(start - 1))).append("\n");
        }

        System.out.print(answer.toString());
    }
}
