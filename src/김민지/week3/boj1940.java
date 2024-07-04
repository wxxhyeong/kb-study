package 김민지.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] items = new int[N];

        // 재료 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(items);

        int startP = 0, endP = N-1, cnt = 0;
        // 양 끝에서 시작
        // sum == M : 양쪽 다 이동
        // sum < M : start 이동
        // sum > M : end 이동
        while (startP < endP) {
            int sum = items[startP] + items[endP];
            if (sum == M) {
                cnt++;
                startP++;
                endP--;
            } else if (sum < M) {
                startP++;
            } else {
                endP--;
            }
        }

        System.out.print(cnt);
    }
}
