package 조우형.week13;

import java.util.*;
import java.io.*;

class boj14501_wh {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer stk;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            int t = arr[i][0];
            int m = arr[i][1];

            if (i+t <= N) {
                if (dp[i + t] < dp[i] + m) {
                    dp[i + t] = dp[i] + m;
                }
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);

        }
        System.out.println(dp[N]);

    }
}