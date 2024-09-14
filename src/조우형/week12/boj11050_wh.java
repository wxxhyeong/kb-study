package 조우형.week12;

import java.util.*;
import java.io.*;

public class boj11050_wh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[][] dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            dp[i][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        System.out.println(dp[N][K]);

    }
}

